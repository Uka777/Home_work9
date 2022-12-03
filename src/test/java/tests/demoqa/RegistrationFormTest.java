package tests.demoqa;

import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationFormTest extends TestBase{
    @Test
    void fillFormTest() {
        step("Open registrations form", () -> {
                    open("/automation-practice-form");
                    $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
                    executeJavaScript("$('footer').remove()");
                    executeJavaScript("$('#fixedban').remove()");
        });
        step("Open registrations form", () -> {
        open("/automation-practice-form");
        $("#firstName").setValue("Julija");
        $("#lastName").setValue("Ivanova");
        $("#userEmail").setValue("Ivanova@mail.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("89195577328");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__day--004").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#currentAddress").setValue("Sovetskaya");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Gurgaon")).click();
        $("#submit").click();
        });
        step("Open registrations form", () -> {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Julija Ivanova"),
                text("Ivanova@mail.ru"),
                text("Female"),
                text("8919557732"),
                text("04 March,1997"),
                text("English"),
                text("Music"),
                text("1.png"),
                text("Sovetskaya"),
                text("NCR Gurgaon"));
        });
    }
}

