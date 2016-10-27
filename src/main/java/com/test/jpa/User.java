package com.test.jpa;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by liusven on 2016/10/25.
 */
@Entity
@Table(name="T_SPRINGJPA_USER")
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name="userName")
    private String userName;

    @Column(name="password")
    private String password;

    @Transient
    private String createDate;

    /*************GET****************SET***************/
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreateDate()
    {
        return new Date().toString();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", passWord="
            + password + ",createDate="+createDate+"]";
    }
}