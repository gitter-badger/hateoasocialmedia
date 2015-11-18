package com.hateoasocialmedia.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String handle;
    private String userDisplayName;
    private String userImageUrl;

    public User() {}

    public User(long theUserId) {
        id = theUserId;
    }

    public long getUserId() {
        return id;
    }

    public void setUserId(long theUserId) {
        id = theUserId;
    }

    public String getUserDisplayName() {
        return userDisplayName;
    }

    public void setUserDisplayName(String theUserDisplayName) {
        userDisplayName = theUserDisplayName;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String theUserImageUrl) {
        userImageUrl = theUserImageUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String theFirstName) {
        firstName = theFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String theLastName) {
        lastName = theLastName;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String theHandle) {
        handle = theHandle;
    }
}
