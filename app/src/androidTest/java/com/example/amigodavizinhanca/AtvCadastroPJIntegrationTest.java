package com.example.amigodavizinhanca;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;


import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AtvCadastroPJIntegrationTest extends TestCase {

    @Rule
    public ActivityScenarioRule<AtvCadastroPJ> activityScenarioRule = new ActivityScenarioRule<AtvCadastroPJ>(AtvCadastroPJ.class);

    @Before
    public void setUp() {
        Intents.init();
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
        onView(withId(R.id.edtNumero)).perform(closeSoftKeyboard());
//        onView(withId(R.id.edtNumero)).perform(scrollTo());
//        onView(withId(R.id.edtComplemento)).perform(scrollTo());
//        onView(withId(R.id.edtComplemento)).perform(scrollTo());
//        onView(withId(R.id.edtComplemento)).perform(scrollTo());
        onView(withId(R.id.edtComplemento)).perform(typeText("Casa 2"));
        onView(withId(R.id.edtComplemento)).perform(closeSoftKeyboard());
        Intent intent = new Intent();
        intent.putExtra("acao", "inserir");
//        Intents.intending(hasComponent(AtvCadastroPJ.class.getName()))
//                .respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, intent));

        Intents.intending(hasComponent("com.example.amigodavizinhanca.AtvCadastroPJ"))
                .respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, intent));

        onView(withId(R.id.btnCadastrarPj)).perform(closeSoftKeyboard(), click());
    }

    @After
    public void tearDown() {
        Intents.release();
    }

}