package fairshare.controller;

import io.javalin.http.Handler;
import fairshare.model.Person;
import fairshare.persistence.PersonDAO;
import fairshare.server.Routes;
import fairshare.server.ServiceRegistry;
import fairshare.server.FairShareServer;

import java.util.Objects;

public class PersonController {

    public static final Handler logout = ctx -> {
        ctx.sessionAttribute(FairShareServer.SESSION_USER_KEY, null);
        ctx.redirect(Routes.LOGIN_PAGE);
    };

    private static final PersonDAO personDAO = ServiceRegistry.lookup(PersonDAO.class);
    public static final Handler login = context -> {
        String email = context.formParamAsClass("email", String.class)
                .check(Objects::nonNull, "Email is required")
                 .get();

        Person person = personDAO.savePerson(new Person(email));
        context.sessionAttribute(FairShareServer.SESSION_USER_KEY, person);
        context.redirect(Routes.EXPENSES);
    };
}
