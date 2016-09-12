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
    //Tests that the random number generator is actually giving at least one of each choice
    public void testRandomResultGenerator(){
        //Initialize counters for each selection
        int rockCount = 0;
        int paperCount = 0;
        int scissorsCount = 0;

        //Get the results from 100 random choices
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

        //Test that each choice has been selected at least once
        Assert.assertTrue(rockCount > 0);
        Assert.assertTrue(paperCount > 0);
        Assert.assertTrue(scissorsCount > 0);

        //Create test log string and log it
        String value = String.format("Rockcount: %d, Papercount: %d, scissorsCount: %d",
                rockCount, paperCount, scissorsCount);

        Log.d("UNIT_TEST", value);
    }

    /*
    TODO: Implement the logic to make this test case pass.
     */
    //Test winner in all cases of Scissors being selected
    public void testScissors(){
        //Simulate player selection
        Integer player = R.id.btnScissors;

        //Test equality results
        Assert.assertEquals(GameUtils.BEATS,GameUtils.evaluateWinner(player,R.id.btnPaper));
        Assert.assertEquals(GameUtils.TIES,GameUtils.evaluateWinner(player, R.id.btnScissors));
        Assert.assertEquals(GameUtils.LOSES_TO,GameUtils.evaluateWinner(player,R.id.btnRock));

        //Test all inequality results:
        //Ties
        Assert.assertNotSame(GameUtils.TIES, GameUtils.evaluateWinner(player, R.id.btnPaper));
        Assert.assertNotSame(GameUtils.TIES, GameUtils.evaluateWinner(player, R.id.btnRock));

        //Wins
        Assert.assertNotSame(GameUtils.BEATS, GameUtils.evaluateWinner(player, R.id.btnRock));
        Assert.assertNotSame(GameUtils.BEATS, GameUtils.evaluateWinner(player, R.id.btnScissors));

        //Losses
        Assert.assertNotSame(GameUtils.LOSES_TO, GameUtils.evaluateWinner(player, R.id.btnScissors));
        Assert.assertNotSame(GameUtils.LOSES_TO, GameUtils.evaluateWinner(player, R.id.btnPaper));
    }

    /*
        TODO: Implement the following logic
    */
    //Test winner in all cases of Rock being selected
    public void testRock(){
        //Simulate player selection
        Integer player = R.id.btnRock;

        //Test equality results
        Assert.assertEquals(GameUtils.BEATS,GameUtils.evaluateWinner(player,R.id.btnScissors));
        Assert.assertEquals(GameUtils.TIES,GameUtils.evaluateWinner(player, R.id.btnRock));
        Assert.assertEquals(GameUtils.LOSES_TO,GameUtils.evaluateWinner(player,R.id.btnPaper));

        //Test all inequality results:
        //Ties
        Assert.assertNotSame(GameUtils.TIES, GameUtils.evaluateWinner(player, R.id.btnPaper));
        Assert.assertNotSame(GameUtils.TIES, GameUtils.evaluateWinner(player, R.id.btnScissors));

        //Wins
        Assert.assertNotSame(GameUtils.BEATS, GameUtils.evaluateWinner(player, R.id.btnRock));
        Assert.assertNotSame(GameUtils.BEATS, GameUtils.evaluateWinner(player, R.id.btnPaper));

        //Losses
        Assert.assertNotSame(GameUtils.LOSES_TO, GameUtils.evaluateWinner(player, R.id.btnScissors));
        Assert.assertNotSame(GameUtils.LOSES_TO, GameUtils.evaluateWinner(player, R.id.btnRock));
    }
    /*
        TODO: Implement the following logic
    */
    //Test winner in all cases of Paper being selected
    public void testPaper(){
        //Simulate player selection
        Integer player = R.id.btnPaper;

        //Test equality results
        Assert.assertEquals(GameUtils.BEATS,GameUtils.evaluateWinner(player,R.id.btnRock));
        Assert.assertEquals(GameUtils.TIES,GameUtils.evaluateWinner(player, R.id.btnPaper));
        Assert.assertEquals(GameUtils.LOSES_TO,GameUtils.evaluateWinner(player,R.id.btnScissors));

        //Test all inequality results:
        //Ties
        Assert.assertNotSame(GameUtils.TIES, GameUtils.evaluateWinner(player, R.id.btnRock));
        Assert.assertNotSame(GameUtils.TIES, GameUtils.evaluateWinner(player, R.id.btnScissors));

        //Wins
        Assert.assertNotSame(GameUtils.BEATS, GameUtils.evaluateWinner(player, R.id.btnScissors));
        Assert.assertNotSame(GameUtils.BEATS, GameUtils.evaluateWinner(player, R.id.btnPaper));

        //Losses
        Assert.assertNotSame(GameUtils.LOSES_TO, GameUtils.evaluateWinner(player, R.id.btnPaper));
        Assert.assertNotSame(GameUtils.LOSES_TO, GameUtils.evaluateWinner(player, R.id.btnRock));
    }

}
