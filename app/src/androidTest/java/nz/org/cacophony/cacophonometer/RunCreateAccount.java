package nz.org.cacophony.cacophonometer;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.filters.LargeTest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Tim Hunt on 14-Mar-18.
 */


@LargeTest
@RunWith(AndroidJUnit4.class)
public class RunCreateAccount {


    @Rule
    public final ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void registerIdlingResource() {
        // let espresso know to synchronize with background tasks
        IdlingRegistry.getInstance().register(IdlingResourceForEspressoTesting.createAccountIdlingResource);
        IdlingRegistry.getInstance().register(IdlingResourceForEspressoTesting.registerPhoneIdlingResource);
        IdlingRegistry.getInstance().register(IdlingResourceForEspressoTesting.signInIdlingResource);
    }

    @After
    public void unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(IdlingResourceForEspressoTesting.createAccountIdlingResource);
        IdlingRegistry.getInstance().unregister(IdlingResourceForEspressoTesting.registerPhoneIdlingResource);
        IdlingRegistry.getInstance().unregister(IdlingResourceForEspressoTesting.signInIdlingResource);

    }


    @Test
    public void createAccount() {

        CreateAccount.createAccount(mActivityTestRule);


    }


}