package com.example.service;


import com.example.dao.NoteRepo;
import com.example.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    NoteRepo noteRepo;

    public Note saveContent(String content)
    {
        Note note=new Note();
        note.setContent(content);
        return noteRepo.save(note);


    }
    public List<Note> getAllNotes()
    {
       return (List<Note>) noteRepo.findAll();

    }
    public Note updateContent(int id,String content)
    {
       Note note1=noteRepo.findById(id).orElse(null);
       if(note1!=null)
       {
           note1.setContent(content);
           noteRepo.save(note1);
       }
       return note1;
    }
}
