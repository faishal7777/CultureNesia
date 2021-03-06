package com.runupstdio.culturenesia.Model;

public class UserStoreData {

    public String username;
    public String email;
    public String score;

    public UserStoreData(String username, String email, String score) {
        this.username = username;
        this.email = email;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
