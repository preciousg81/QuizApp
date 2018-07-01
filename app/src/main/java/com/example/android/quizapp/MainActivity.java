package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String finalMessage = "";
    CheckBox exo_cb, endo_cb, anto_cb, pneumo_cb;
    EditText temp_field, math_field;
    RadioGroup rdg1, rdg2, rdg3, rdg4, rdg5, rdg6, rdg7;
    RadioButton big_heart, heart_nation, finger, oil_city, increase, decrease, david_mark, bukola, agege, shehu, true_rdb, false_rdb, one_rdb, two_rdb, three_rdb, carnivore_rdb, herbivore_rdb, omnivore_rdb, tiger_rdb, wild_cat_rdb, lion_rdb, cheetah_rdb;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdg1 = (RadioGroup) findViewById(R.id.radio_group1);
        rdg2 = (RadioGroup) findViewById(R.id.radio_group2);
        rdg3 = (RadioGroup) findViewById(R.id.radio_group3);
        rdg4 = (RadioGroup) findViewById(R.id.radio_group4);
        rdg5 = (RadioGroup) findViewById(R.id.radio_group5);
        rdg6 = (RadioGroup) findViewById(R.id.radio_group6);
        rdg7 = (RadioGroup) findViewById(R.id.radio_group7);

        temp_field = (EditText) findViewById(R.id.edit_text_1);
        math_field = (EditText) findViewById(R.id.edit_text_2);

        exo_cb = (CheckBox) findViewById(R.id.exo_check_box);
        endo_cb = (CheckBox) findViewById(R.id.endo_check_box);
        anto_cb = (CheckBox) findViewById(R.id.anto_check_box);
        pneumo_cb = (CheckBox) findViewById(R.id.pneumo_check_box);
        big_heart = (RadioButton) findViewById(R.id.big_heart_rb);
        heart_nation = (RadioButton) findViewById(R.id.heart_nation_rb);
        finger = (RadioButton) findViewById(R.id.finger_rb);
        oil_city = (RadioButton) findViewById(R.id.oil_city_rb);
        increase = (RadioButton) findViewById(R.id.increase_rb);
        decrease = (RadioButton) findViewById(R.id.decrease_rb);
        david_mark = (RadioButton) findViewById(R.id.david_mark_rb);
        bukola = (RadioButton) findViewById(R.id.bukola_rb);
        agege = (RadioButton) findViewById(R.id.agege_rb);
        shehu = (RadioButton) findViewById(R.id.shehu_rb);
        true_rdb = (RadioButton) findViewById(R.id.true_rb);
        false_rdb = (RadioButton) findViewById(R.id.false_rb);
        one_rdb = (RadioButton) findViewById(R.id.one_rb);
        two_rdb = (RadioButton) findViewById(R.id.two_rb);
        three_rdb = (RadioButton) findViewById(R.id.three_rb);
        carnivore_rdb = (RadioButton) findViewById(R.id.carnivorous_rb);
        herbivore_rdb = (RadioButton) findViewById(R.id.herbivorous_rb);
        omnivore_rdb = (RadioButton) findViewById(R.id.omnivorous_rb);
        tiger_rdb = (RadioButton) findViewById(R.id.tiger_rb);
        wild_cat_rdb = (RadioButton) findViewById(R.id.wild_cat_rb);
        lion_rdb = (RadioButton) findViewById(R.id.lion_rb);
        cheetah_rdb = (RadioButton) findViewById(R.id.cheetah_rb);
    }

    /**
     * This method displays the final result of the quiz and a toast of the correct answers.
     */
    public void showResult(View view) {
        //determines the correct option for question 1
        boolean question1IsCorrect = heart_nation.isChecked();

        //determines the correct option for question 2
        boolean question2IsCorrect = increase.isChecked();

        //determines the correct option for question 3
        boolean question3IsCorrect = bukola.isChecked();

        //determines the correct option for question 4
        boolean question4IsCorrect = true_rdb.isChecked();

        //gets the entered value for question 5
        String temp = temp_field.getText().toString();

        //determines the correct option for question 6
        boolean question6IsCorrect = false;
        if (exo_cb.isChecked()) {
            if (endo_cb.isChecked()) {
                if (anto_cb.isChecked()) {
                } else {
                    if (pneumo_cb.isChecked()) {
                    } else {
                        question6IsCorrect = true;
                    }
                }
            }
        }

        //gets the entered value for question 7
        String factorial = math_field.getText().toString();

        //determines the correct option for question 8
        boolean question8IsCorrect = two_rdb.isChecked();

        //determines the correct option for question 9
        boolean question9IsCorrect = carnivore_rdb.isChecked();

        //determines the correct option for question 8
        boolean question10IsCorrect = lion_rdb.isChecked();

        //computes the final scores by grading the options selected by the user
        int finalScore = calculateScore(question1IsCorrect, question2IsCorrect, question3IsCorrect, question4IsCorrect, question6IsCorrect, question8IsCorrect, question9IsCorrect, question10IsCorrect, temp, factorial);

        //calculates the percentage of the final score
        double valued = finalScore;
        double percent = (valued / 10) * 100;

        //computes the message to display in the blank textView upon the click of the Done button
        finalMessage = createSummaryMessage();
        displayMessage(finalMessage);

        //the message to be displayed as toast when the Done button is clicked
        String answers = "You scored " + finalScore + " over 10";
        answers += "\nRepresenting " + percent + " percent";
        if (percent < 45) {
            answers += "\nImprovement needed";
        }
        if (percent > 80) {
            answers += "\nAwesome job. Congratulations!";
        }
        Toast.makeText(getApplicationContext(), answers, Toast.LENGTH_LONG).show();

    }

    /**
     * This method computes the quiz score for the user
     * @param question1IsCorrect checks if question 1 is correct and scores the user accordingly
     * @param question2IsCorrect checks if question 2 is correct and scores the user accordingly
     * @param question3IsCorrect checks if question 3 is correct and scores the user accordingly
     * @param question4IsCorrect checks if question 4 is correct and scores the user accordingly
     * @param question6IsCorrect checks if question 6 is correct and scores the user accordingly
     * @param question8isCorrect checks if question 8 is correct and scores the user accordingly
     * @param question9isCorrect checks if question 9 is correct and scores the user accordingly
     * @param question10isCorrect checks if question 10 is correct and scores the user accordingly
     * @param temp checks if entry for question 5 is correct and scores the user accordingly
     * @param factorial checks if entry for question 7 is correct and scores the user accordingly
     * @return for the final quiz score
     */
    private int calculateScore(boolean question1IsCorrect, boolean question2IsCorrect, boolean question3IsCorrect, boolean question4IsCorrect, boolean question6IsCorrect, boolean question8isCorrect, boolean question9isCorrect, boolean question10isCorrect, String temp, String factorial) {

        int quizScore = 0;

        if (question1IsCorrect)
        {
            quizScore += 1;
        }

        if (question2IsCorrect)
        {
            quizScore += 1;
        }

        if (question3IsCorrect)
        {
            quizScore += 1;
        }

        if (question4IsCorrect)
        {
            quizScore += 1;
        }

        if (question6IsCorrect) {
            quizScore += 1;
        }

        if ((temp).equals("100")) {
            quizScore += 1;
        }

        if ((factorial).equals("120")) {
            quizScore += 1;
        }

        if (question8isCorrect) {
            quizScore += 1;
        }

        if (question9isCorrect) {
            quizScore += 1;
        }

        if (question10isCorrect) {
            quizScore += 1;
        }

        return quizScore;
    }

    /**
     * This method computes the summary message to be displayed
     */
    private String createSummaryMessage() {

        String summaryMessage = "Thank you for completing the Quiz.";
        summaryMessage += "\nYou deserve some Accolades.";
        return summaryMessage;
    }

    /**
     * This method resets or restarts the Quiz
     */
    public void resetQuiz (View v) {
        rdg1.clearCheck();
        rdg2.clearCheck();
        rdg3.clearCheck();
        rdg4.clearCheck();
        rdg5.clearCheck();
        rdg6.clearCheck();
        rdg7.clearCheck();
        exo_cb.setChecked(false);
        endo_cb.setChecked(false);
        anto_cb.setChecked(false);
        pneumo_cb.setChecked(false);
        temp_field.setText("");
        math_field.setText("");
        finalMessage = "";
        displayMessage(finalMessage);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView statusTextView = (TextView) findViewById(R.id.result_text_view);
        statusTextView.setText(message);
    }

    /**
     * This method checks the status of the checkboxes.
     */
    public void onCheckBoxClicked(View view) {
    }

    /**
     * This method checks the status of the radio buttons.
     */
    public void onRadioButtonClicked(View view) {

    }
}