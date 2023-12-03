package com.example.amigodavizinhanca;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class CadastroDeServicoTest {

    @Rule
    public ActivityScenarioRule<CadastroDeServico> activityRule = new ActivityScenarioRule<>(CadastroDeServico.class);

    @Test
    public void testComponentsInitialization() {
        // Verifica se os componentes da interface do usuário são inicializados corretamente
        onView(withId(R.id.btnCadastrar)).check(matches(isDisplayed()));
        onView(withId(R.id.edtNomeVaga)).check(matches(isDisplayed()));
        // Adicione verificações para outros elementos conforme necessário
    }

    @Test
    public void testButtonClick() {
        // Realiza ações de teste aqui usando Espresso
        onView(withId(R.id.btnCadastrar)).perform(click());
        // Adicione verificações adicionais conforme necessário
    }
}
