package com.example.fetchvalue.Model;

import com.google.gson.annotations.SerializedName;

public class Employee {
    @SerializedName("id")
    private String id;
    @SerializedName("login")
    private String login;
    @SerializedName("type")
    private String type;
    @SerializedName("html_url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
