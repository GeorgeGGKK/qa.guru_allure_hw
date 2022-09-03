package com.github;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class IssueTests extends BaseTest {
    WebStep step = new WebStep();

    @DisplayName("Поиск Issue +Listener")
    @Test
    void searchIssuesListener() {
        open("/selenide/selenide");
        $x("//a[@id='issues-tab']").click();
        $x("//div[@aria-label='Issues']").shouldHave(text("Exception in thread \"Dead threads watchdog\""));
        $x("//div[@aria-label='Issues']").shouldHave(text("Add caching API into standard API"));
        $x("//div[@aria-label='Issues']").shouldHave(text("Add method to getall CSS properties of web element"));
    }

    @DisplayName("Поиск Issue +Lambda - Step")
    @Test
    void searchIssuesLambdaStep() {
        step("Открываем репозиторий Selenide в Github", () -> {
            open("/selenide/selenide");
        });
        step("Нажимаем на вкладку Issues", () -> {
            $x("//a[@id='issues-tab']").click();
        });
        step("Проверяем наличие Issues", () -> {
            $x("//div[@aria-label='Issues']").shouldHave(text("Exception in thread \"Dead threads watchdog\""));
            $x("//div[@aria-label='Issues']").shouldHave(text("Add caching API into standard API"));
            $x("//div[@aria-label='Issues']").shouldHave(text("Add method to getall CSS properties of web element"));
        });
    }

    @DisplayName("Поиск Issue +Annotation Step")
    @Test
    void searchIssuesAnnotationStep() {
        step.openRepositorySelenidePage()
                .openTabIssues()
                .checkIssues();
    }
}
