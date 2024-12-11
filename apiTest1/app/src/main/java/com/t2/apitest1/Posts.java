package com.t2.apitest1;
import com.google.gson.annotations.SerializedName;

public class Posts {


    private String title;
    private String body;


    public Posts(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
