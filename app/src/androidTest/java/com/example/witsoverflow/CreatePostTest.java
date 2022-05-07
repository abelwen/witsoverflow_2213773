package com.example.witsoverflow;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.witsoverflow.CreatePost;

import org.junit.After;
import org.junit.Before;
import org.junit.Before;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class CreatePostTest {


    @Rule
    public ActivityScenarioRule<CreatePost> tCreatePostScenarioRule = new ActivityScenarioRule<CreatePost>(CreatePost.class);

    private ActivityScenario<CreatePost> tCreatePost = null;

    @Before
    public void setUp() throws Exception {

        tCreatePost = tCreatePostScenarioRule.getScenario();

    }

    @Test

    public void testLaunch(){

        assertNotNull(onView(withId(R.id.textCaption)));
        assertNotNull(onView(withId(R.id.textTags)));
        assertNotNull(onView(withId(R.id.textPost)));
        assertNotNull(onView(withId(R.id.buttonBack)));
        assertNotNull(onView(withId(R.id.buttonPost)));



    }


    @After
    public void tearDown() throws Exception {

        tCreatePost = null ;
    }

}
