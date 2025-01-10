package fairshare.model;

/*
 ** DO NOT CHANGE!!
 */

import org.junit.jupiter.api.Test;

import fairshare.model.Person;
import fairshare.model.FairShareException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonTests {
    @Test
    public void invalidEmailAddressFails() {
        assertThatThrownBy(() -> new Person("not an email"))
                .isInstanceOf(FairShareException.class)
                .hasMessageContaining("Bad email address");
    }

    @Test
    public void nameFromEmailAddress() {
        Person p = new Person("student@wethinkcode.co.za");
        assertThat(p.getName()).isEqualTo("Student");
    }
}
