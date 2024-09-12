package com.example.dao;

import com.example.model.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepo extends CrudRepository<Note,Integer> {
}
