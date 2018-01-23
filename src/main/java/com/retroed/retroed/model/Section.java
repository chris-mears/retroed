package com.retroed.retroed.model;

public class Section {
    private Long id;
    private Long retroId;
    private String title;
    private String notes;
    public Section() {
        super();
    }
    public Section(Long id, Long retroId, String title, String notes) {
        super();
        this.id = id;
        this.retroId = retroId;
        this.title = title;
        this.notes = notes;
    }
    public Section(Long retroId, String title, String notes) {
        super();
        this.retroId = retroId;
        this.title = title;
        this.notes = notes;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getRetorId() {
        return retroId;
    }
    public void setRetroId(Long retroId) {
        this.retroId = retroId;
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
        return String.format("Student [id=%s, retroId=%s, title=%s, notes=%s]", id, retroId, title, notes);
    }
}

