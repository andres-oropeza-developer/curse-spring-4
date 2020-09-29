package com.udemy.backendninja.crudcontacts.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "log")
public class LogEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "date", nullable = false, length = 20)
    private Date date;

    @Column(name = "user_name", nullable = false, length = 80)
    private String username;

    @Column(name = "detail", nullable = false, length = 255)
    private String detail;

    @Column(name = "url", nullable = false, length = 255)
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LogEntity(Date date, String username, String detail, String url) {
        super();
        this.date = date;
        this.username = username;
        this.detail = detail;
        this.url = url;
    }

    public LogEntity() {
    }

    @Override
    public String toString() {
        return "LogEntity{" +
                "id=" + id +
                ", date=" + date +
                ", username='" + username + '\'' +
                ", detail='" + detail + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
