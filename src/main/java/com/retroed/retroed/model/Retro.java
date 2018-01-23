package com.retroed.retroed.model;

public class Retro {
    private Long id;
    private String name;
    private String body;
    public Retro() {
        super();
    }
    public Retro(Long id, String name, String body) {
        super();
        this.id = id;
        this.name = name;
        this.body = body;
    }
    public Retro(String name, String body) {
        super();
        this.name = name;
        this.body = body;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getbody() {
        return body;
    }
    public void setbody(String body) {
        this.body = body;
    }
    @Override
    public String toString() {
        return String.format("Student [id=%s, name=%s, body=%s]", id, name, body);
    }
}
