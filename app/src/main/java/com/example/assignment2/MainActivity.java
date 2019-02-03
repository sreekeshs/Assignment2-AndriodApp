package com.example.assignment2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    private final DecimalFormat FORMAT = new DecimalFormat("#.##");
    private EditText soloEarned;
    private EditText soloPoss;
    private EditText teamEarned;
    private EditText teamPoss;
    private EditText midEarned;
    private EditText midPoss;
    private EditText finalEarned;
    private EditText finalPoss;
    private Button calculate;
    private AutoCompleteTextView totalAvg;
    private AutoCompleteTextView letterGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        soloEarned = (EditText)findViewById(R.id.soloEarned);
        soloPoss = (EditText)findViewById(R.id.soloPoss);
        teamEarned = (EditText)findViewById(R.id.teamEarned);
        teamPoss = (EditText)findViewById(R.id.teamPoss);
        midEarned = (EditText)findViewById(R.id.midEarned);
        midPoss = (EditText)findViewById(R.id.midPoss);
        finalEarned = (EditText)findViewById(R.id.finalEarned);
        finalPoss = (EditText)findViewById(R.id.finalPoss);
        calculate = (Button)findViewById(R.id.calculate);
        totalAvg = (AutoCompleteTextView)findViewById(R.id.totalAvg);
        letterGrade = (AutoCompleteTextView)findViewById(R.id.letterGrade);

    }

    public void onClick (View view) {

        switch (view.getId()) {

            case R.id.reset:
                soloEarned.setText("");
                soloPoss.setText("");
                teamEarned.setText("");
                teamPoss.setText("");
                midEarned.setText("");
                midPoss.setText("");
                finalEarned.setText("");
                finalPoss.setText("");
                break;

            case R.id.calculate:
                String soloInput = soloEarned.getText().toString();
                String solototal = soloPoss.getText().toString();

                String teamInput = teamEarned.getText().toString();
                String teamtotal = teamPoss.getText().toString();

                String midInput = midEarned.getText().toString();
                String midtotal = midPoss.getText().toString();

                String finalInput = finalEarned.getText().toString();
                String finaltotal = finalPoss.getText().toString();

                String grade;

                if(soloInput.length() > 0 && solototal.length() >  0 && teamInput.length() > 0
                        && teamtotal.length() > 0 && midInput.length() > 0 && midtotal.length() > 0
                        && finalInput.length() > 0 && finaltotal.length() > 0) {

                    double soloWAvg = (Double.parseDouble(soloInput) / (Double.parseDouble(solototal)) )* 0.20;
                    double teamWAvg = (Double.parseDouble(teamInput) / (Double.parseDouble(teamtotal)) )* 0.30;
                    double midWAvg = (Double.parseDouble(midInput) / (Double.parseDouble(midtotal)) )* 0.20;
                    double finalWAvg = (Double.parseDouble(finalInput) / (Double.parseDouble(finaltotal)) )* 0.30;

                    double result = (soloWAvg + teamWAvg + midWAvg + finalWAvg) * 100;

                    if (result >= 90) {
                        grade = "A";
                    } else if (result >= 80 && result < 90) {
                        grade = "B";
                    } else if (result >= 70 && result < 80) {
                        grade = "C";
                    } else if (result >= 60 && result < 70) {
                        grade = "D";
                    } else {
                        grade = "F";
                    }

                    totalAvg.setText(FORMAT.format(result));
                    letterGrade.setText(grade);


                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "Scores aren't given. Unable to calculate average.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
        }
    }
}
