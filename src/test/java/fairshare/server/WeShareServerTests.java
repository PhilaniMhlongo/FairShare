package fairshare.server;

/*
 ** DO NOT CHANGE!!
 */

import org.junit.jupiter.api.Test;

import fairshare.server.FairShareServer;

import static org.assertj.core.api.Assertions.assertThat;

public class WeShareServerTests {

    @Test
    public void ifServerStartsThenItIsProperlyConfigured() {
        FairShareServer server = new FairShareServer();
        server.start(0);
        assertThat(server.port()).isGreaterThan(0);
    }
}
