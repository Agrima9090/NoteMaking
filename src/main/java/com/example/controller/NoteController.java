package com.example.controller;


import com.example.model.Note;
import com.example.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NoteController {
    @Autowired
    NoteService noteService;
    @RequestMapping("/start")
    public String showWelcomePage()
    {
        return "welcome";
    }
    @RequestMapping("/create")
    public String showAppPage()
    {
        return "create";
    }
    @RequestMapping("/save")
    public String writeContent(@RequestParam("noteContent") String content, Model model)
    {

        if(content.trim().isEmpty())
        {
            return "error";
        }
        else {
            Note note=noteService.saveContent(content);

            model.addAttribute("noteId", note.getNoteId());
            model.addAttribute("content", note.getContent());
            return "save";
        }

    }
    @RequestMapping("/view")
    public String getAllNotes(Model model) {
        List<Note> notes = noteService.getAllNotes();
        model.addAttribute("notes", notes);
        return "showAll";
    }

    @RequestMapping(value = "/edit-note",method = RequestMethod.POST)
    public String editNote(@RequestParam("noteId") int id,
                           @RequestParam("content") String content,
                           Model model)
    {
        Note note=noteService.updateContent(id,content);
        model.addAttribute("notId",note.getNoteId());
        model.addAttribute("content",note.getContent());
        return "update";
    }
}
