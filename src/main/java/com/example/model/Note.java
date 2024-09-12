package com.example.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int noteId;
    private String content;

    public Note() {
    }

    public Note(String content) {
        this.content = content;
    }

    public int getNoteId() {
        return noteId;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", content='" + content + '\'' +
                '}';
    }
}
