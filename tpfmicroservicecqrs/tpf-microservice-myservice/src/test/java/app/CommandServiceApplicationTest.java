package app;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration
@ActiveProfiles({"dev"})
public class CommandServiceApplicationTest {
    @Inject
    ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
        assertNotNull("application context loaded", applicationContext);
    }

}
