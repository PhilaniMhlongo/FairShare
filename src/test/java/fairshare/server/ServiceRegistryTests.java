package fairshare.server;

/*
 ** DO NOT CHANGE!!
 */

import org.junit.jupiter.api.Test;

import fairshare.persistence.PersonDAO;
import fairshare.persistence.collectionbased.PersonDAOImpl;
import fairshare.server.ServiceRegistry;
import fairshare.server.FairShareServer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ServiceRegistryTests {

    @Test
    public void configureService() {
        PersonDAO dao = new PersonDAOImpl();
        ServiceRegistry.configure(PersonDAO.class, dao);
        assertThat(ServiceRegistry.lookup(PersonDAO.class)).isEqualTo(dao);
    }

    @Test
    public void registryNotInitialised() {
        assertThatThrownBy(() -> ServiceRegistry.lookup(FairShareServer.class))
                .isInstanceOf(RuntimeException.class)
                .hasMessageStartingWith("No service configured for");
    }
}
