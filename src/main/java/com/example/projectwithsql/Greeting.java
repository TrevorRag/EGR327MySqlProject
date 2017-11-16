package com.example.projectwithsql;

import javax.persistence.*;


@Entity
@Table(name = "greetings")
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String content;


    public Greeting(){
        this.id = 0;
        this.content = "";
    }

    public Greeting(int id, String content){
        this.id = id;
        this.content = content;
    }

    public Greeting(String content){
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
