package com.test.jpa;

import javax.persistence.*;

/**
 * Created by liusven on 2016/10/25.
 */
@Entity
@Table(name="T_SPRINGJPA_USER")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="USER_PASSWORD")
    private String passWord;

    /*************GET****************SET***************/
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", passWord="
            + passWord + "]";
    }
}