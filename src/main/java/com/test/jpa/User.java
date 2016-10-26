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

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="USER_PASSWORD")
    private String passWord;

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
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord)
    {
        this.passWord = passWord;
    }

    public String getCreateDate()
    {
        return new Date().toString();
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", passWord="
            + passWord + ",createDate="+createDate+"]";
    }
}