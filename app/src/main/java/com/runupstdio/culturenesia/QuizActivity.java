package com.runupstdio.culturenesia;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.runupstdio.culturenesia.Splash.SplashActivity;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_1, btn_2, btn_3;
    TextView mPertanyaan, mScoreQuiz, time;
    int score;
    CountDownTimer countDown;
    Bundle ini;
    String extras;
    private static int BTN_TIME_OUT = 2000;
    private Quizionaire question = new Quizionaire();
    private String answer;
    private int questionLength = question.questions.length;
    private int questionNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ini = getIntent().getExtras();
        extras = ini.getString("level");

        btn_1 = findViewById(R.id.jawaban1);
        btn_1.setOnClickListener(this);
        btn_2 = findViewById(R.id.jawaban2);
        btn_2.setOnClickListener(this);
        btn_3 = findViewById(R.id.jawaban3);
        btn_3.setOnClickListener(this);

        time = findViewById(R.id.countDown);
        mScoreQuiz = findViewById(R.id.skorQuiz);
        mPertanyaan = findViewById(R.id.pertanyaan);
        questionNow = 0;
        nextQuestion(questionNow);

        score = 0;
//        mScoreQuiz.setText(score);
        start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jawaban1:
                if (btn_1.getText() == answer){
                    setScoreQuiz();
                    btn_1.setBackgroundResource(R.drawable.bg_jawaban_benar);
                    Toast.makeText(this, "jawabanmu bener bos", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (questionNow != (questionLength-1)){
                                btn_1.setBackgroundResource(R.drawable.bg_jawaban);
                                questionNow++;
                                nextQuestion(questionNow);
                            } else {
                                showDialog();
                            }
                        }
                    }, BTN_TIME_OUT);
                } else {
                    btn_1.setBackgroundResource(R.drawable.bg_jawaban_salah);
                    Toast.makeText(this, "jawabanmu salah bos", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (questionNow != (questionLength-1)){
                                btn_1.setBackgroundResource(R.drawable.bg_jawaban);
                                questionNow++;
                                nextQuestion(questionNow);
                            } else {
                                startActivity(new Intent(QuizActivity.this, SplashActivity.class));
                            }
                        }
                    }, BTN_TIME_OUT);
                } break;

            case R.id.jawaban2:
                if (btn_2.getText() == answer){
                    setScoreQuiz();
                    btn_2.setBackgroundResource(R.drawable.bg_jawaban_benar);
                    Toast.makeText(this, "jawabanmu bener bos", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (questionNow != (questionLength-1)){
                                btn_2.setBackgroundResource(R.drawable.bg_jawaban);
                                questionNow++;
                                nextQuestion(questionNow);
                            } else {
                                startActivity(new Intent(QuizActivity.this, SplashActivity.class));
                            }
                        }
                    }, BTN_TIME_OUT);
                } else {
                    btn_2.setBackgroundResource(R.drawable.bg_jawaban_salah);
                    Toast.makeText(this, "jawabanmu salah bos", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (questionNow != (questionLength-1)){
                                btn_2.setBackgroundResource(R.drawable.bg_jawaban);
                                questionNow++;
                                nextQuestion(questionNow);
                            } else {
                                startActivity(new Intent(QuizActivity.this, SplashActivity.class));
                            }
                        }
                    }, BTN_TIME_OUT);
                } break;

            case R.id.jawaban3:
                if (btn_3.getText() == answer){
                    setScoreQuiz();
                    btn_3.setBackgroundResource(R.drawable.bg_jawaban_benar);
                    Toast.makeText(this, "jawabanmu bener bos", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (questionNow != (questionLength-1)){
                                btn_3.setBackgroundResource(R.drawable.bg_jawaban);
                                questionNow++;
                                nextQuestion(questionNow);
                            } else {
                                startActivity(new Intent(QuizActivity.this, SplashActivity.class));
                            }
                        }
                    }, BTN_TIME_OUT);
                } else {
                    btn_3.setBackgroundResource(R.drawable.bg_jawaban_salah);
                    Toast.makeText(this, "jawabanmu salah bos", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (questionNow != (questionLength-1)){
                                btn_3.setBackgroundResource(R.drawable.bg_jawaban);
                                questionNow++;
                                nextQuestion(questionNow);
                            } else {
                                startActivity(new Intent(QuizActivity.this, SplashActivity.class));
                            }
                        }
                    }, BTN_TIME_OUT);
                } break;
        }
    }

    private void setScoreQuiz(){
        score = score + 20;
        mScoreQuiz.setText(String.valueOf(score));
    }

    private void nextQuestion(int num) {
        if (extras.equals("1")){
            mPertanyaan.setText(question.getQuestion(num));
            btn_1.setText(question.getChoice1(num));
            btn_2.setText(question.getChoice2(num));
            btn_3.setText(question.getChoice3(num));

            answer = question.getCorrectAnswer(num);
        } else if (extras.equals("2")){
            mPertanyaan.setText(question.getQuestion(num));
            btn_1.setText(question.getChoice1(num));
            btn_2.setText(question.getChoice2(num));
            btn_3.setText(question.getChoice3(num));

            answer = question.getCorrectAnswer(num);
        } else if (extras.equals("3")){
            mPertanyaan.setText(question.getQuestion(num));
            btn_1.setText(question.getChoice1(num));
            btn_2.setText(question.getChoice2(num));
            btn_3.setText(question.getChoice3(num));

            answer = question.getCorrectAnswer(num);
        } else if (extras.equals("4")){
            mPertanyaan.setText(question.getQuestion(num));
            btn_1.setText(question.getChoice1(num));
            btn_2.setText(question.getChoice2(num));
            btn_3.setText(question.getChoice3(num));

            answer = question.getCorrectAnswer(num);
        }

    }

    public void start(){
        countDown = new CountDownTimer(60000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                String waktu = "" + millisUntilFinished / 1000;
                time.setText(waktu);
            }

            @Override
            public void onFinish() {

            }
        };
        countDown.start();
    }

    public void showDialog(){
        DoneDialog popupDialog = new DoneDialog();
        popupDialog.setNilai(score);
        popupDialog.show(getSupportFragmentManager(),"reserve dialog");
    }
}
