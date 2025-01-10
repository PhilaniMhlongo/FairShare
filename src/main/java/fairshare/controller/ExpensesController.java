package fairshare.controller;

import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import fairshare.model.DateHelper;
import fairshare.model.Expense;
import fairshare.model.MoneyHelper;
import fairshare.model.Person;
import fairshare.persistence.ExpenseDAO;
import fairshare.server.Routes;
import fairshare.server.ServiceRegistry;
import fairshare.server.FairShareServer;

import javax.money.MonetaryAmount;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

import static fairshare.model.MoneyHelper.amountOf;

public class ExpensesController {



    public static final Handler view = context -> {
        ExpenseDAO expensesDAO = ServiceRegistry.lookup(ExpenseDAO.class);
        Person personLoggedIn = FairShareServer.getPersonLoggedIn(context);

        Collection<Expense> expenses = expensesDAO.findExpensesForPerson(personLoggedIn);
        Collection<Expense> filteredExpense = expenses.stream().filter(expense -> !expense.isFullyPaidByOthers()).toList();


        MonetaryAmount totalAmount = calculateTotalAmount(filteredExpense);

        Map<String, Object> viewModel = Map.of("expenses", filteredExpense, "total", totalAmount);
        context.render("expenses.html", viewModel);
    };

    public static final Handler newExpense = context -> {
        ExpenseDAO expensesDAO = ServiceRegistry.lookup(ExpenseDAO.class);
        ExpenseDAO expenseDAO = ServiceRegistry.lookup(ExpenseDAO.class);
        Person personLoggedIn = FairShareServer.getPersonLoggedIn(context);
        Collection<Expense> expenses = expensesDAO.findExpensesForPerson(personLoggedIn);

        Map<String, Object> viewModel = Map.of("expenses", expenses);
        context.render("newexpense.html");
    };

    public static Handler addExpense = context -> {
        Person personLoggedIn = FairShareServer.getPersonLoggedIn(context);
        ExpenseDAO expensesDAO = ServiceRegistry.lookup(ExpenseDAO.class);
        String description = getFormParam(context, "description", "Description is required");
        long amount = Long.parseLong(getFormParam(context, "amount", "Amount is required"));
        String date = getFormParam(context, "date", "Date is required");

        expensesDAO.save(new Expense(personLoggedIn, description, MoneyHelper.amountOf(amount), DateHelper.TODAY));

        context.sessionAttribute(FairShareServer.SESSION_USER_KEY, personLoggedIn);
        context.redirect(Routes.EXPENSES);
    };

    public static Handler paymentRequest = context -> {
        Person personLoggedIn = FairShareServer.getPersonLoggedIn(context);
        ExpenseDAO expensesDAO = ServiceRegistry.lookup(ExpenseDAO.class);
        Collection<Expense> expenses = expensesDAO.findExpensesForPerson(personLoggedIn);

        System.out.println("Hit the payment expense button");
        Map<String, Object> viewModel = Map.of("expenses", expenses);
    };

    private static MonetaryAmount calculateTotalAmount(Collection<Expense> expenses) {
        return expenses.stream()
                .map(Expense::amountLessPaymentsReceived)
                .reduce(MoneyHelper.ZERO_RANDS, MonetaryAmount::add);
    }

    private static String getFormParam(io.javalin.http.Context context, String paramName, String errorMsg) {
        return context.formParamAsClass(paramName, String.class)
                .check(Objects::nonNull, errorMsg)
                .get();
    }
}
