package com.example.sendvalues.ModelClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {
    private String Title;
    private String Body;
    Json json;

    public Json getJson() {
        return json;
    }

    public void setJson(Json json) {
        this.json = json;
    }

    public Model(String title, String body) {
        Title = title;
        Body = body;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }
}
