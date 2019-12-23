package Tests;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features", //путь к папке с .feature файлами
        tags = "@FishTextAPITests", //фильтр запускаемых тестов по тэгам
        snippets = SnippetType.UNDERSCORE
)
public class RunnerTest {
}