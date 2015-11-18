package com.hateoasocialmedia.status;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long statusId;
    private long userId;
    private String text;
    private long responseTo;
    private Timestamp postTime;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long theUserId) {
        userId = theUserId;
    }

    public String getText() {
        return text;
    }

    public void setText(String theText) {
        text = theText;
    }

    public long getResponseTo() {
        return responseTo;
    }

    public void setResponseTo(long theResponseTo) {
        responseTo = theResponseTo;
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    @Override
    public boolean equals(Object other) {
        if(null == other)
            return false;
        if(this == other)
            return true;
        if(!(other instanceof Status))
            return false;
        Status other_status = (Status)other;
        return userId == other_status.getUserId();
    }

    @Override
    public int hashCode() {
        return new Long(userId).hashCode();
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatus_id(long statusId) {
        this.statusId = statusId;
    }
}
