package com.runupstdio.culturenesia;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_1, btn_2, btn_3, btn_4;
    TextView mPertanyaan, mScoreQuiz, time;
    int score;
    trueAnswerLoad trueAnswerLoad;
    falseAnswerLoad falseAnswerLoad;
    CountDownTimer countDown;
    Bundle ini;
    String extras;

    private Quizionaire question = new Quizionaire();
    private String answer;
    private int questionLength = question.questions.length;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ini = getIntent().getExtras();
        extras = ini.getString("level");

        score = 0;
        random = new Random();
        trueAnswerLoad = new trueAnswerLoad(this);
        falseAnswerLoad = new falseAnswerLoad(this);

        btn_1 = findViewById(R.id.jawaban1);
        btn_1.setOnClickListener(this);
        btn_2 = findViewById(R.id.jawaban2);
        btn_2.setOnClickListener(this);
        btn_3 = findViewById(R.id.jawaban3);
        btn_3.setOnClickListener(this);
        btn_4 = findViewById(R.id.jawaban4);
        btn_4.setOnClickListener(this);

        time = (TextView) findViewById(R.id.countDown);
        mScoreQuiz = findViewById(R.id.skorQuiz);
        mPertanyaan = findViewById(R.id.pertanyaan);
        nextQuestion(random.nextInt(questionLength));
        start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jawaban1:
                if (btn_1.getText() == answer){
                    setScoreQuiz();
                    Toast.makeText(this, "jawabanmu bener bos", Toast.LENGTH_SHORT).show();
                    nextQuestion(random.nextInt(questionLength));
                } else {
                    Toast.makeText(this, "jawabanmu salah bos", Toast.LENGTH_SHORT).show();
                    nextQuestion(random.nextInt(questionLength));
                } break;
            case R.id.jawaban2:
                if (btn_2.getText() == answer){
                    setScoreQuiz();
                    Toast.makeText(this, "jawabanmu bener bos", Toast.LENGTH_SHORT).show();
                    nextQuestion(random.nextInt(questionLength));
                } else {
                    Toast.makeText(this, "jawabanmu salah bos", Toast.LENGTH_SHORT).show();
                    nextQuestion(random.nextInt(questionLength));
                } break;
            case R.id.jawaban3:
                if (btn_3.getText() == answer){
                    setScoreQuiz();
                    Toast.makeText(this, "jawabanmu bener bos", Toast.LENGTH_SHORT).show();
                    nextQuestion(random.nextInt(questionLength));
                } else {
                    Toast.makeText(this, "jawabanmu salah bos", Toast.LENGTH_SHORT).show();
                    nextQuestion(random.nextInt(questionLength));
                } break;
            case R.id.jawaban4:
                if (btn_4.getText() == answer){
                    setScoreQuiz();
                    Toast.makeText(this, "jawabanmu bener bos", Toast.LENGTH_SHORT).show();
                    nextQuestion(random.nextInt(questionLength));
                } else {
                    Toast.makeText(this, "jawabanmu salah bos", Toast.LENGTH_SHORT).show();
                    nextQuestion(random.nextInt(questionLength));
                } break;
        }
    }

    private void setScoreQuiz(){
        score = score + 20;
        mScoreQuiz.setText(score);
    }

    private void nextQuestion(int num) {
        if (extras.equals("1")){
            mPertanyaan.setText(question.getQuestion(num));
            btn_1.setText(question.getChoice1(num));
            btn_2.setText(question.getChoice2(num));
            btn_3.setText(question.getChoice3(num));
            btn_4.setText(question.getChoice4(num));

            answer = question.getCorrectAnswer(num);
        } else if (extras.equals("2")){
            mPertanyaan.setText(question.getQuestion(num));
            btn_1.setText(question.getChoice1(num));
            btn_2.setText(question.getChoice2(num));
            btn_3.setText(question.getChoice3(num));
            btn_4.setText(question.getChoice4(num));

            answer = question.getCorrectAnswer(num);
        } else if (extras.equals("3")){
            mPertanyaan.setText(question.getQuestion(num));
            btn_1.setText(question.getChoice1(num));
            btn_2.setText(question.getChoice2(num));
            btn_3.setText(question.getChoice3(num));
            btn_4.setText(question.getChoice4(num));

            answer = question.getCorrectAnswer(num);
        } else if (extras.equals("4")){
            mPertanyaan.setText(question.getQuestion(num));
            btn_1.setText(question.getChoice1(num));
            btn_2.setText(question.getChoice2(num));
            btn_3.setText(question.getChoice3(num));
            btn_4.setText(question.getChoice4(num));

            answer = question.getCorrectAnswer(num);
        }

    }

    public void start(){
        countDown = new CountDownTimer(60000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                String waktu = "w : " + millisUntilFinished / 1000;
                time.setText(waktu);
            }

            @Override
            public void onFinish() {

            }
        };
        countDown.start();
    }
}
