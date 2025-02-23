package pl.soek.jira.cucumber.Options;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("pl/soek/jira/features")
@ConfigurationParameter(key = "cucumber.glue", value = "pl.soek.jira")
public class CucumberTestRunner {
}
