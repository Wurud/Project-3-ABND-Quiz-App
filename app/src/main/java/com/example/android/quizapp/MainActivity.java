package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Define variables in the global scope.
    EditText logoName;
    CheckBox steveJobs;
    CheckBox steveWozniak;
    CheckBox ronaldWayne;
    CheckBox timCook;
    float correctAnswers;
    public DecimalFormat totalFormat = new DecimalFormat(".##");

    //This method is called when the submit button is clicked.
    public void submitAnswers(View view) {

        //------Question One------
        logoName = (EditText) findViewById(R.id.companyName);
        String companyName = logoName.getText().toString().trim();

        //------Question Two------
        steveJobs = (CheckBox) findViewById(R.id.checkbox_optionOne);
        steveWozniak = (CheckBox) findViewById(R.id.checkbox_optionTwo);
        ronaldWayne = (CheckBox) findViewById(R.id.checkbox_optionThree);
        timCook = (CheckBox) findViewById(R.id.checkbox_optionFour);

        boolean qTwoAnswerOne = steveJobs.isChecked();
        boolean qTwoAnswerTwo = steveWozniak.isChecked();
        boolean qTwoAnswerThree = ronaldWayne.isChecked();
        boolean qTwoAnswerFour = timCook.isChecked();

        //------Question Three----
        RadioButton barackObama = (RadioButton) findViewById(R.id.barackObama_radio_button);
        RadioButton billGates = (RadioButton) findViewById(R.id.billGates_radio_button);
        RadioButton oprahWinfrey = (RadioButton) findViewById(R.id.oprahWinfrey_radio_button);

        boolean qThreeAnswerOne = barackObama.isChecked();
        boolean qThreeAnswerTwo = billGates.isChecked();
        boolean qThreeAnswerThree = oprahWinfrey.isChecked();

        //------Question Four-----
        RadioButton google = (RadioButton) findViewById(R.id.google_radio_button);
        RadioButton walmart = (RadioButton) findViewById(R.id.walmart_radio_button);
        RadioButton bpplc = (RadioButton) findViewById(R.id.BPPlc_radio_button);

        boolean qFourAnswerOne = google.isChecked();
        boolean qFourAnswerTwo = walmart.isChecked();
        boolean qFourAnswerThree = bpplc.isChecked();

        //------Pass variables to each question method-----
        questionOneAnswer(companyName);
        questionTwoAnswer(qTwoAnswerOne, qTwoAnswerTwo, qTwoAnswerThree, qTwoAnswerFour);
        questionThreeAnswer(qThreeAnswerOne, qThreeAnswerTwo, qThreeAnswerThree);
        questionFourAnswer(qFourAnswerOne, qFourAnswerTwo, qFourAnswerThree);

        //------Display result as a Toast Message-----
        displayMsg(correctAnswers);
    }

    /*
     * This method will check Question One
     * @param companyName Udacity company name
     */
    public void questionOneAnswer(String companyName) {

        if (companyName.equalsIgnoreCase("Udacity")) {

            correctAnswers += +1;
        }
    }

    /*
    * This method will check Question Two
    * @param optionOne steveJobs - correct answer
    * @param optionTwo steveWozniak - correct answer
    * @param optionThree ronaldWayne - correct answer
    * @param optionFour timCook
    */
    public void questionTwoAnswer(boolean optionOne, boolean optionTwo, boolean optionThree, boolean optionFour) {
        if (optionOne && optionTwo && optionThree && !optionFour) {
            correctAnswers += 1;
        }
    }

    /*
    * This method will check Question Three
    * @param optionOne Barack Obama
    * @param optionTwo Bill Gates
    * @param optionThree Oprah Winfrey - correct answer
    */
    public void questionThreeAnswer(boolean optionOne, boolean optionTwo, boolean optionThree) {
        if (optionThree) {
            correctAnswers += 1;
        }
    }

    /*
   * This method will check Question Four
   * @param optionOne Google
   * @param optionTwo Walmart - correct answer
   * @param optionThree BP plc
   */
    public void questionFourAnswer(boolean optionOne, boolean optionTwo, boolean optionThree) {
        if (optionTwo) {
            correctAnswers += 1;
        }
    }

    /*
     * This method will display result in a Toast message
     * @param total the total of the correct answers that have been chosen
     */
    public void displayMsg(float total) {
        if (total == 4) {
            //Show error msg as a Toast
            Toast.makeText(this, "Congratulations! your result is 4 out of 4 :)", Toast.LENGTH_SHORT).show();
            correctAnswers = 0;
        } else {

            Toast.makeText(this, "Ooops! your result is " + totalFormat.format(total) + "out of 4 :)", Toast.LENGTH_SHORT).show();
            correctAnswers = 0;
        }
        //Exit the method
        return;
    }

    /*
     * This method will reset the form
     * @param total the total of the currect answers that has been chosen
     */
    public void reset(View view) {

        correctAnswers = 0;
        logoName.setText("");
        steveJobs.setChecked(false);
        steveWozniak.setChecked(false);
        ronaldWayne.setChecked(false);
        timCook.setChecked(false);

        RadioGroup groupThree = (RadioGroup) findViewById(R.id.questionThree);
        groupThree.clearCheck();

        RadioGroup groupFour = (RadioGroup) findViewById(R.id.questionFour);
        groupFour.clearCheck();

    }
}
