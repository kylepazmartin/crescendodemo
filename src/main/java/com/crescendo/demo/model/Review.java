package com.crescendo.demo.model;

public class Review {

    private String id;
    private String url;
    private String text;
    private String rating;
    private String time_created;
    private User user;

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }

    public String getRating() {
        return rating;
    }

    public String getTime_created() {
        return time_created;
    }

    public User getUser() {
        return user;
    }
}
