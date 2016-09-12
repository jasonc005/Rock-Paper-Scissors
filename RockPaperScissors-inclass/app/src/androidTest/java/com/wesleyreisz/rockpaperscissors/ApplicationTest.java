package com.wesleyreisz.rockpaperscissors;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.wesleyreisz.rockpaperscissors.Game.GameUtils;

import junit.framework.Assert;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }
    /*
    TODO: Implement test logic to test the random number generator.
    */
    public void testRandomResultGenerator(){
        int rockCount = 0;
        int paperCount = 0;
        int scissorsCount = 0;

        for (int i = 0; i < 100; i++) {
            Integer choice = GameUtils.getComputerChoice();
            if (choice == R.id.btnRock) {
                rockCount++;
            } else if (choice == R.id.btnPaper) {
                paperCount++;
            } else if (choice == R.id.btnScissors) {
                scissorsCount++;
            } else {
                Log.d("Test", "Wes You could do better!");
            }
        }

        Assert.assertTrue(rockCount > 0);
        Assert.assertTrue(paperCount > 0);
        Assert.assertTrue(scissorsCount > 0);

        String value = String.format("Rockcount: %d, Papercount: %d, scissorsCount: %d",
                rockCount, paperCount, scissorsCount);

        Log.d("UNIT_TEST", value);
    }

    /*
    TODO: Implement the logic to make this test case pass.
     */
    public void testScissors(){
        Integer player = R.id.btnScissors;

        Assert.assertEquals(GameUtils.BEATS,GameUtils.evaluateWinner(player,R.id.btnPaper));
        Assert.assertEquals(GameUtils.TIES,GameUtils.evaluateWinner(player, R.id.btnScissors));
        Assert.assertEquals(GameUtils.LOSES_TO,GameUtils.evaluateWinner(player,R.id.btnRock));

        Assert.assertNotSame(GameUtils.TIES, GameUtils.evaluateWinner(player, R.id.btnPaper));
    }

    /*
        TODO: Implement the following logic
    */
    public void testRock(){

        assertTrue(false);
    }
    /*
        TODO: Implement the following logic
    */
    public void testPaper(){
        assertTrue(false);
    }

}
