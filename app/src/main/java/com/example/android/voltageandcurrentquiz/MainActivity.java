package com.example.android.voltageandcurrentquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;


/**
 * This app is used to test your voltage and current electricity knowledge.
 */
public class MainActivity extends AppCompatActivity {

    EditText question4Field, nameField;

    //Question 4 correct string value to compare in showResults method
    String question4CorrectAnswer = "AMPERE";

    // Integer variable to store questions in total
    int questionsInTotal  = 4;

    // Integer variable to store user's correct answers for showResult method
    int usersCorrectAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set all caps for  question4_field EditText
        question4Field = (EditText) findViewById(R.id.question4_field);
        question4Field.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

        //Set all caps for  name_field EditText
        nameField = (EditText) findViewById(R.id.name_field);
        nameField.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
    }

    //Method to calculate and show results in TOAST message
    public void showResult(View view) {
        // Get user's name
        Editable nameEditable = nameField.getText();
        String name = nameEditable.toString();

        Log.v("MainActivity", "Full name: " + name);

        //Check if correct answer is checked for question1
        RadioButton question1RadioButton1 = (RadioButton) findViewById(R.id.radio_button1_question1);

        if(question1RadioButton1.isChecked()){
            usersCorrectAnswers++;}
        Log.v("MainActivity", "Score after first question: " + usersCorrectAnswers);

        //Check if correct answer is checked for question2
        RadioButton question2RadioButton3 = (RadioButton) findViewById(R.id.radio_button3_question2);

        if(question2RadioButton3.isChecked()){
            usersCorrectAnswers++;}
        Log.v("MainActivity", "Score after second question: " + usersCorrectAnswers);

        //Check if wrong answer 1 is checked for question3
        CheckBox question3CheckBox1 = (CheckBox) findViewById(R.id.checkbox1_question3);

        //Check if correct answer 1 is checked for question3
        CheckBox question3CheckBox2 = (CheckBox) findViewById(R.id.checkbox2_question3);

        //Check if correct answer 2 is checked for question3
        CheckBox question3CheckBox3 = (CheckBox) findViewById(R.id.checkbox3_question3);

        if (question3CheckBox1.isChecked()){
            usersCorrectAnswers = usersCorrectAnswers;
        }else if(question3CheckBox2.isChecked() && question3CheckBox3.isChecked()){
            usersCorrectAnswers++;}
        Log.v("MainActivity", "Score after third question: " + usersCorrectAnswers);

        // Get question 4 edited value to compare string to  name
        Editable question4Editable = question4Field.getText();
        String question4Value = question4Editable.toString();
        Log.v("MainActivity", "Question 4 string: [" + question4Value + "]" );
        if(question4Value.equals(question4CorrectAnswer)){
            usersCorrectAnswers++;}
        Log.v("MainActivity", "Score after second question: " + usersCorrectAnswers);

        //Show score TOAST message
        Toast.makeText(this, getString(R.string.user_have_answered, name) + " " + usersCorrectAnswers + " " + getString(R.string.of) + " " + questionsInTotal + " " +getString(R.string.correct_answers), Toast.LENGTH_LONG).show();
        usersCorrectAnswers = 0;
    }
}
