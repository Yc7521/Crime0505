package org.yc.crimeintent3.model;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;

public class Crime implements Serializable {
    private String id;
    private String title;
    private Date date;
    private Boolean isSolved;

    public Crime() {
    }

    public Crime(String id,
                 String title,
                 Date date,
                 Boolean isSolved) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.isSolved = isSolved;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getSolved() {
        return isSolved;
    }

    public void setSolved(Boolean solved) {
        isSolved = solved;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("Crime{id='%s', title='%s', date=%s, isSolved=%s}",
                id,
                title,
                date,
                isSolved);
    }
}
