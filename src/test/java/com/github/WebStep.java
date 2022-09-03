package com.github;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class WebStep {

    @Step("Открываем репозиторий Selenide в Github")
    public WebStep openRepositorySelenidePage() {
        open("/selenide/selenide");
        return this;
    }

    @Step("Нажимаем на вкладку Issues")
    public WebStep openTabIssues() {
        $x("//a[@id='issues-tab']").click();
        return this;
    }

    @Step("Проверяем наличие Issues")
    public WebStep checkIssues() {
        $x("//div[@aria-label='Issues']").shouldHave(text("Exception in thread \"Dead threads watchdog\""));
        $x("//div[@aria-label='Issues']").shouldHave(text("Add caching API into standard API"));
        $x("//div[@aria-label='Issues']").shouldHave(text("Add method to getall CSS properties of web element"));
        return this;
    }
}
