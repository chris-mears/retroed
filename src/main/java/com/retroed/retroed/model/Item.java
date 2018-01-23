package com.retroed.retroed.model;

public class Item {
    private Long id;
    private Long retroId;
    private Long sectionId;
    private String title;
    private String notes;
    public Item() {
        super();
    }
    public Item(Long id, Long retroId, Long sectionId, String title, String notes) {
        super();
        this.id = id;
        this.retroId = retroId;
        this.sectionId = sectionId;
        this.title = title;
        this.notes = notes;
    }
    public Item(Long retroId, Long sectionId, String title, String notes) {
        super();
        this.retroId = retroId;
        this.sectionId = sectionId;
        this.title = title;
        this.notes = notes;
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
    public Long getSectionIdId() {
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
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    @Override
    public String toString() {
        return String.format("Student [id=%s, retroId=%s, sectionId=%s, title=%s, notes=%s]", id, retroId, sectionId, title, notes);
    }
}
