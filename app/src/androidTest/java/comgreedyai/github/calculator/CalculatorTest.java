package comgreedyai.github.calculator;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Waley on 2017/10/2.
 */

@RunWith(AndroidJUnit4.class)
public class CalculatorTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void simplePlus() {
        onView(withText("2")).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("2")));
        onView(withText("+")).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("2+")));
    }

    @Test
    public void correctAddition() {
        onView(withText("2")).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("2")));
        onView(withText("+")).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("2+")));
        onView(withText("3")).perform(click());
        onView(withId(R.id.result)).check(matches(withText("5")));
    }

    @Test
    public void correctAddition2() {
        onView(withId(R.id.num_2)).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("2")));
        onView(withText("+")).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("2+")));
        onView(withId(R.id.num_2)).perform(click());
        onView(withId(R.id.result)).check(matches(withText("4")));
    }

    @Test
    public void correctSubtraction() {
        onView(withText("2")).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("2")));
        onView(withText("-")).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("2-")));
        onView(withText("3")).perform(click());
        onView(withId(R.id.result)).check(matches(withText("-1")));
    }

    @Test
    public void correctSequenceOfOperations() {
        onView(withText("-")).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("-")));
        onView(withText("1")).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("-1")));
        onView(withText("+")).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("-1+")));
        onView(withText("2")).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("-1+2")));
        onView(withText("-")).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("-1+2-")));
        onView(withText("3")).perform(click());
        onView(withId(R.id.result)).check(matches(withText("-2")));
    }

    @Test
    public void plusAsFirstOperation() {
        onView(withId(R.id.plus)).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("+")));
        onView(withId(R.id.num_0)).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("+0")));
        onView(withId(R.id.plus)).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("+0+")));
        onView(withId(R.id.num_2)).perform(click());
        onView(withId(R.id.result)).check(matches(withText("2")));
    }

    @Test
    public void decimalAsFirstOperation() {
        onView(withId(R.id.dot)).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("0.")));
        onView(withId(R.id.num_5)).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("0.5")));
        onView(withId(R.id.minus)).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("0.5-")));
        onView(withId(R.id.num_0)).perform(click());
        onView(withId(R.id.result)).check(matches(withText("0.5")));
    }

    @Test
    public void decimalComputation() {
        onView(withId(R.id.num_2)).perform(click());
        onView(withId(R.id.result)).check(matches(withText("2")));
        onView(withId(R.id.dot)).perform(click());
        onView(withId(R.id.result)).check(matches(withText("2")));
        onView(withId(R.id.num_4)).perform(click());
        onView(withId(R.id.result)).check(matches(withText("2.4")));
        onView(withId(R.id.minus)).perform(click());
        onView(withId(R.id.result)).check(matches(withText("2.4")));
        onView(withId(R.id.num_6)).perform(click());
        onView(withId(R.id.result)).check(matches(withText("-3.6")));
        onView(withId(R.id.dot)).perform(click());
        onView(withId(R.id.result)).check(matches(withText("-3.6")));
        onView(withId(R.id.num_8)).perform(click());
        onView(withId(R.id.result)).check(matches(withText("-4.4")));
    }

    @Test
    public void tryToError() {
        onView(withId(R.id.num_2)).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("2")));
        onView(withId(R.id.dot)).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("2.")));
        onView(withId(R.id.dot)).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("2.")));
        onView(withId(R.id.minus)).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("2.")));
        onView(withId(R.id.num_6)).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("2.6")));
        onView(withId(R.id.plus)).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("2.6+")));
        onView(withId(R.id.plus)).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("2.6+")));
        onView(withId(R.id.num_8)).perform(click());
        onView(withId(R.id.result)).check(matches(withText("10.6")));
    }

    @Test
    public void clearAndEqual() {
        onView(withId(R.id.num_2)).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("2")));
        onView(withId(R.id.minus)).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("2-")));
        onView(withId(R.id.num_9)).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("2-9")));
        onView(withId(R.id.equals)).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("-7")));
        onView(withId(R.id.ce)).perform(click());
        onView(withId(R.id.expression)).check(matches(withText("0")));
        onView(withId(R.id.result)).check(matches(withText("0")));
    }
    @Test
    public void largeNumbers() {
        for(int i = 0 ; i<15 ; i++) {
            onView(withId(R.id.num_0)).perform(click());
        }
        onView(withId(R.id.result)).check(matches(withText("0")));
        for(int i = 0 ; i<15 ; i++) {
            onView(withId(R.id.num_1)).perform(click());
        }
        onView(withId(R.id.result)).check(matches(withText("111111111111111")));
        onView(withId(R.id.minus)).perform(click());
        for(int i = 0 ; i<14 ; i++) {
            onView(withId(R.id.num_1)).perform(click());
        }
        onView(withId(R.id.expression)).check(matches(withText("000000000000000111111111111111-11111111111111")));
        onView(withId(R.id.result)).check(matches(withText("100000000000000")));
    }
}
