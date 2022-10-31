package saga.choreography.with.deadline.handling.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import saga.choreography.with.deadline.handling.ExchangeApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { ExchangeApplication.class })
public class CucumberSpingConfiguration {}
