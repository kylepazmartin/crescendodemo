package com.crescendo.demo.model;

public class User {

    private String id;
    private String profile_url;
    private String name;
    private String image_url;
    private String emotion;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }
}
