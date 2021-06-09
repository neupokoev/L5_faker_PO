package docs;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {

    void cssXpathExamples() {

        // group: https://t.me/xpath_help
        // hints: https://devhints.io/xpath

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="royal_email">

        $("[data-testid=royal_email]").setValue("some@email.com");
        $(by("data-testid", "royal_email")).setValue("some@email.com");


        // <input type="email" class="inputtext login_form_input_box" name="email" id="email">

        $("[id='email']").setValue("some@email.com");
        $("[id=\"email\"]").setValue("some@email.com");
        $("[id=email]").setValue("some@email.com");
        $("#email").setValue("some@email.com");                                  // <- use this
        $(byId("email")).setValue("some@email.com");
        $("input[id=email]").setValue("some@email.com");
        $("input#email").setValue("some@email.com");
        $(by("id", "email")).setValue("some@email.com");

        $x("//input[@id='email']").setValue("some@email.com");
        $x("//*[@name='email']").setValue("some@email.com");
        $(byXpath("//*[@name='email']")).setValue("some@email.com");


        // <input type="email" class="inputtext login_form_input_box" name="email">

        $("[name='email']").setValue("some@email.com");
        $("input[name='email']").setValue("some@email.com");
        $(by("name", "email")).setValue("some@email.com");
        $(byName("email")).setValue("some@email.com");                                     // <- use this


        // <input type="email" class="inputtext login_form_input_box">

        $(byClassName("login_form_input_box")).setValue("some@email.com");
        $(".login_form_input_box").setValue("some@email.com");                    // <- use this
        $(".inputtext.login_form_input_box").setValue("some@email.com");
        $("input.inputtext.login_form_input_box").setValue("some@email.com");
        $("input.inputtext.login_form_input_box[type='email']").setValue("some@email.com");

        $x("//*[@class='login_form_input_box']").setValue("some@email.com");


        // <div type="email" class="inputtext">
        //      <input class="login_form_input_box">
        // </div>

        $(".inputtext .login_form_input_box").setValue("some@email.com");
        $(".inputtext").$(".login_form_input_box").setValue("some@email.com");
        $(".inputtext").find(".login_form_input_box").setValue("some@email.com");

    }
}
