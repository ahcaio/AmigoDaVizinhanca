package com.example.amigodavizinhanca;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.CoreMatchers.allOf;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AtvCadastroPJIntegrationTest extends TestCase {

    @Rule
    public ActivityScenarioRule<AtvCadastroPJ> activityScenarioRule = new ActivityScenarioRule<AtvCadastroPJ>(AtvCadastroPJ.class);

    @Test
    public void testaPreencherCamposDoCadastroPJEClicarNoBotaoCadastrar() {
        // Etapa 1: Simular o cadastro de uma empresa PJ
        onView(withId(R.id.edtRazaoSocial)).perform(replaceText("Instituição teste"));
        onView(withId(R.id.edtEmail)).perform(typeText("teste@gmail.com"));
        onView(withId(R.id.edtCNPJ)).perform(typeText("1234567890-0001/00"));
        onView(withId(R.id.edtCEP)).perform(typeText("74290-045"));
        onView(withId(R.id.edtLogradouro)).perform(typeText("Avenida teste"));
        onView(withId(R.id.edtLocalidade)).perform(replaceText("Goiânia"));
        onView(withId(R.id.edtUF)).perform(replaceText("Goiás"));
        onView(withId(R.id.edtNumero)).perform(typeText("1000"));
        onView(withId(R.id.edtComplemento)).perform(typeText("Casa 2"));

        onView(withId(R.id.btnCadastrarPj)).perform(click());

    }

    @Test
    public void testaCadastroDePessoaJuridica() {
        // Etapa 1: Simular o cadastro de uma empresa PJ
        onView(withId(R.id.edtRazaoSocial)).perform(replaceText("Instituição teste"));
        onView(withId(R.id.edtEmail)).perform(typeText("teste@gmail.com"));
        onView(withId(R.id.edtCNPJ)).perform(typeText("1234567890-0001/00"));
        onView(withId(R.id.edtCEP)).perform(typeText("74290-045"));
        onView(withId(R.id.edtLogradouro)).perform(typeText("Avenida teste"));
        onView(withId(R.id.edtLocalidade)).perform(replaceText("Goiânia"));
        onView(withId(R.id.edtUF)).perform(replaceText("Goiás"));
        onView(withId(R.id.edtNumero)).perform(typeText("1000"));
        onView(withId(R.id.edtComplemento)).perform(typeText("Casa 2"));

        onView(withId(R.id.btnCadastrarPj)).perform(click());
    }

}