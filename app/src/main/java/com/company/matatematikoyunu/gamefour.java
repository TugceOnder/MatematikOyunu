package com.company.matatematikoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class gamefour extends AppCompatActivity {
    TextView score;
    TextView life;
    TextView time;

    TextView question;
    EditText answer;

    Button okey;
    Button nextQuestion;

    Random random= new Random();
    int number1,number2,userAnswer,realAnswer;
    int userScore=0;
    int userLife=3;
    CountDownTimer timer;
    private static final long START_TIMER_IN_MILLS=60000;
    Boolean timer_running;
    long time_left_milis=START_TIMER_IN_MILLS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        score=(TextView) findViewById(R.id.textViewScore);
        life=(TextView)findViewById(R.id.textViewlife);
        time=(TextView)findViewById(R.id.textViewTime);
        question=(TextView)findViewById(R.id.textViewQuestions);
        answer=(EditText) findViewById(R.id.editTextAnswer);
        okey=(Button)findViewById(R.id.buttonOkey);
        nextQuestion=(Button)findViewById(R.id.buttonNext);
        gamecontinue();

        okey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userAnswer =Integer.valueOf(answer.getText().toString());
                pauseTimer();
                if (userAnswer==realAnswer)

                {
                    userScore=userScore+10;
                    question.setText("Tebrikler Cevabınız Dogrudur");
                    score.setText(""+userScore);
                }
                else

                {
                    userLife=userLife-1;
                    question.setText("Uzgunum Cevabınız Yanlış");
                    life.setText(""+userLife);
                }

            }
        });


        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText("");
                gamecontinue();
                resetTimer();
                if(userLife==0)

                {
                    Toast.makeText(getApplicationContext(),"GAME OVER",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(gamefour.this,Result.class);
                    intent.putExtra("score",userScore);
                    startActivity(intent);
                    finish();
                }

                else

                {

                    gamecontinue();
                }

            }
        });
    }

    public  void  gamecontinue()
    {
        number1=random.nextInt(100);
        number2=random.nextInt(100);
        question.setText(number1+" / "+number2);
        realAnswer=number1/number2;
        startTimer();
        okey.setClickable(true);
        startTimer();
    }

    public void startTimer()
    {
        timer= new CountDownTimer(time_left_milis,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                time_left_milis=millisUntilFinished;
                updateText();
            }

            @Override
            public void onFinish() {
                timer_running=false;
                pauseTimer();
                resetTimer();
                updateText();
                userLife=userLife-1;
                question.setText("ÜZGÜNÜM SÜRE DOLDU");


            }
        }.start();
        timer_running=true;
    }


    public void updateText()
    {
        int second=(int)(time_left_milis/1000)%60;
        String time_left=String.format(Locale.getDefault(),"%02d",second);
        time.setText(time_left);
    }

    public void pauseTimer()
    {
        timer.cancel();
        timer_running=false;
    }
    public void resetTimer()
    {
        time_left_milis=START_TIMER_IN_MILLS;
        updateText();
    }
}