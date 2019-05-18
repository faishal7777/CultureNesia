package com.runupstdio.culturenesia;

public class Quizionaire {

    public String questions[] = {
            "Apa nama ibukota provinsi Jawa Timur?",
            "Sudah Makan Belum?",
            "Monggo Pinarek"
    };

    public String choices[][] = {
            {"PHP", "MOODLE", "JEMBOD", "ASU"},
            {"PHP", "MOODLE", "JEMBOD", "ASU"},
            {"PHP", "MOODLE", "JEMBOD", "ASU"}
    };

    public String correctAnswer[] = {
            "PHP",
            "JEMBOD",
            "MOODLE"
    };

    public String getQuestion(int a){
        String question = questions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice = choices[a][0];
        return choice;
    }

    public String getChoice2(int a){
        String choice = choices[a][1];
        return choice;
    }

    public String getChoice3(int a){
        String choice = choices[a][2];
        return choice;
    }

    public String getChoice4(int a){
        String choice = choices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = correctAnswer[a];
        return answer;
    }
}
