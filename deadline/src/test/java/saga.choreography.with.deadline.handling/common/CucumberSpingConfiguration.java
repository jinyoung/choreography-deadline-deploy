package saga.choreography.with.deadline.handling.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import saga.choreography.with.deadline.handling.DeadlineApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { DeadlineApplication.class })
public class CucumberSpingConfiguration {}
