package fairshare.persistence;



import fairshare.model.Expense;
import fairshare.model.PaymentRequest;
import fairshare.model.Person;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface ExpenseDAO {
    Collection<Expense> findExpensesForPerson(Person person);

    Expense save(Expense expense);

    Optional<Expense> get(UUID id);

    Collection<PaymentRequest> findPaymentRequestsSent(Person person);

    Collection<PaymentRequest> findPaymentRequestsReceived(Person person);
}
