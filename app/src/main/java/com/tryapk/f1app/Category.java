package com.tryapk.f1app;

public class Category {
    private String name;
    private String url;
    private int iconResId;

    public Category(String name, String url, int iconResId) {
        this.name = name;
        this.url = url;
        this.iconResId = iconResId;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public int getIconResId() {
        return iconResId;
    }
}