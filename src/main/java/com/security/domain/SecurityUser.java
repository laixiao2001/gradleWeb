package com.security.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liusven on 2016/11/4.
 */
@Entity
@Table(name="securityUser")
public class SecurityUser {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="ssoId", unique=true, nullable=false)
    private String ssoId;

    @Column(name="password", nullable=false)
    private String password;

    @Column(name="firstName", nullable=false)
    private String firstName;

    @Column(name="lastName", nullable=false)
    private String lastName;

    @Column(name="email", nullable=false)
    private String email;

    @Column(name="state", nullable=false)
    private String state=State.ACTIVE.getState();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "securityUserUserProfile",
        joinColumns = { @JoinColumn(name = "userId") },
        inverseJoinColumns = { @JoinColumn(name = "userProfileId") })
    private Set<UserProfile> userProfiles = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSsoId() {
        return ssoId;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Set<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((ssoId == null) ? 0 : ssoId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof SecurityUser))
            return false;
        SecurityUser other = (SecurityUser) obj;
        if (id != other.id)
            return false;
        if (ssoId == null) {
            if (other.ssoId != null)
                return false;
        } else if (!ssoId.equals(other.ssoId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", ssoId=" + ssoId + ", password=" + password
            + ", firstName=" + firstName + ", lastName=" + lastName
            + ", email=" + email + ", state=" + state + ", userProfiles=" + userProfiles +"]";
    }


}
