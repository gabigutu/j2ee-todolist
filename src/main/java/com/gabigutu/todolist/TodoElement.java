package com.gabigutu.todolist;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import java.io.Serializable;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class TodoElement implements Serializable {

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
