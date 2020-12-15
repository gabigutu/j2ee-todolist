package com.gabigutu.todolist;

public class TodoElement {

    private String title;
    private boolean done;

    public TodoElement(String title) {
        this.title = title;
        done = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

}
