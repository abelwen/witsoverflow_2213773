package com.example.witsoverflow;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.witsoverflow.SignUp;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class SignUpTest
{
    @Rule
    public ActivityScenarioRule<SignUp> tSignUpScenarioRule = new ActivityScenarioRule<SignUp>(SignUp.class);

    private ActivityScenario<SignUp> tSignUp = null;

    @Before
    public void setUp() throws Exception {

        tSignUp = tSignUpScenarioRule.getScenario();

    }

    @Test

    public void testLaunch(){

        assertNotNull( onView(withId(R.id.Name)));
        assertNotNull(onView(withId(R.id.Surname)));
        assertNotNull(onView(withId(R.id.email)));
        assertNotNull(onView(withId(R.id.cell_num)));
        assertNotNull(onView(withId(R.id.password)));
        assertNotNull(onView(withId(R.id.address)));
        assertNotNull(onView(withId(R.id.stud_num)));

    }


    @After
    public void tearDown() throws Exception {

        tSignUp = null ;
    }
}
