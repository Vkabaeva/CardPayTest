package Tests;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        tags = "@FishTextAPITests",
        glue = "/src/test/java/Tests",
        snippets = SnippetType.CAMELCASE
)
public class RunnerTest {
}