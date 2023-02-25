import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeworkFour {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void gitHubCheckInnerSelenide() {
        open("https://github.com/");
        $("[placeholder='Search GitHub']").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $("div.markdown-body").shouldHave(Condition.text("Soft assertions"));
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(byText("SoftAssertions")).shouldBe(Condition.visible).click();
        $(".markdown-body").shouldHave(Condition.text("Using JUnit5 extend test class"));
    }
}
