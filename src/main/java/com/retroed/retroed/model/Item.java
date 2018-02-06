package com.retroed.retroed.model;

import java.util.Date;

public class Item {
    private Long id;
    private Long retroId;
    private Long sectionId;
    private String title;
    private String body;
    private Date dueDate;
    public Item() {
        super();
    }
    public Item(Long id, Long retroId, Long sectionId, String title, String body, Date dueDate) {
        super();
        this.id = id;
        this.retroId = retroId;
        this.sectionId = sectionId;
        this.title = title;
        this.body = body;
        this.dueDate = dueDate;
    }
    public Item(Long retroId, Long sectionId, String title, String body, Date dueDate) {
        super();
        this.retroId = retroId;
        this.sectionId = sectionId;
        this.title = title;
        this.body = body;
        this.dueDate = dueDate;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getRetroId() {
        return retroId;
    }
    public void setRetroId(Long retroId) {
        this.retroId = retroId;
    }
    public Long getSectionId() {
        return sectionId;
    }
    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String notes) {
        this.body = body;
    }
    public Date getDueDate() { return dueDate; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }

    @Override
    public String toString() {
        return String.format("Item [id=%s, retroId=%s, sectionId=%s, title=%s, body=%s, dueDate=%s]", id, retroId, sectionId, title, body, dueDate);
    }
}
