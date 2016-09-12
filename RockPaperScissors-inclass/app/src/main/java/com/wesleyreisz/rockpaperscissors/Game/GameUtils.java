package com.wesleyreisz.rockpaperscissors.Game;

import android.graphics.Color;
import com.wesleyreisz.rockpaperscissors.R;

import java.util.Random;

/**
 * Created by wesleyreisz on 9/13/15.
 */
public class GameUtils {
    public static final String BEATS = "beats";
    public static final String LOSES_TO = "loses to";
    public static final String TIES = "ties";

    public static Integer getComputerChoice(){

        Random rand = new Random();

        int n = rand.nextInt(3) + 1;
        if(n==1){
            return R.id.btnPaper;
        }else if(n==2){
            return R.id.btnRock;
        }else{
            return R.id.btnScissors;
        }

    }

    public static String evaluateWinner(Integer playerSelectedChoice, Integer computerSelectedChoice) {
        /*
        R.id.btnRock;
        R.id.btnScissors;
        R.id.btnPaper;
        */

        //TODO: Create some logic to evaluate winner.
        switch(playerSelectedChoice){
            //if player selects rock
            case R.id.btnRock:
                //Rock TIES Rock
                if(computerSelectedChoice == R.id.btnRock)
                    return GameUtils.TIES;
                //Rock LOSES TO Paper
                else if(computerSelectedChoice == R.id.btnPaper)
                    return GameUtils.LOSES_TO;
                //Rock BEATS Scissors
                else if(computerSelectedChoice == R.id.btnScissors)
                    return GameUtils.BEATS;
                break;

            //if player selects paper
            case R.id.btnPaper:
                //Paper BEATS Rock
                if(computerSelectedChoice == R.id.btnRock)
                    return GameUtils.BEATS;
                //Paper TIES Paper
                else if(computerSelectedChoice == R.id.btnPaper)
                    return GameUtils.TIES;
                //Paper LOSES TO Scissors
                else if(computerSelectedChoice == R.id.btnScissors)
                    return GameUtils.LOSES_TO;
                break;

            //if player selects scissors
            case R.id.btnScissors:
                //Scissors LOSES TO Rock
                if(computerSelectedChoice == R.id.btnRock)
                    return GameUtils.LOSES_TO;
                //Scissors BEATS Paper
                else if(computerSelectedChoice == R.id.btnPaper)
                    return GameUtils.BEATS;
                //Scissors TIES Scissors
                else if(computerSelectedChoice == R.id.btnScissors)
                    return GameUtils.TIES;
                break;
        }//END switch


        /*
        These are the constants that should be returned
        GameUtils.BEATS;
        GameUtils.TIES;
        GameUtils.LOSES_TO;
        */
        return GameUtils.BEATS;
    }

    public static Integer convertButtonToImage(Integer buttonChoice) {
        if(buttonChoice==R.id.btnRock){
            return R.drawable.rock;
        }else if (buttonChoice==R.id.btnPaper){
            return R.drawable.paper;
        }else{
            return R.drawable.scissors;
        }
    }

    public static int defineTextColor(String msg) {
        if(GameUtils.LOSES_TO.equalsIgnoreCase(msg)){
            return Color.RED;
        }else if(GameUtils.BEATS.equalsIgnoreCase(msg)){
            return Color.GREEN;
        }else{
            return Color.BLACK;
        }
    }
}

