package fullStack.implementation.web.controller;

import fullStack.implementation.persistence.entity.Note;
import fullStack.implementation.persistence.entity.User;
import fullStack.implementation.service.NoteService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAll(){
        return ResponseEntity.ok(this.noteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable("id") int id){
        return ResponseEntity.ok(this.noteService.getNote(id));
    }

    @PostMapping
    public ResponseEntity<Note> save (@RequestBody Note note){
        if(note.getIdNote() == null || !this.noteService.exist(note.getIdNote())){
            return ResponseEntity.ok(this.noteService.save(note));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Note> update(@RequestBody Note note){
        if(note.getIdNote()!= null && this.noteService.exist(note.getIdNote())){
            return ResponseEntity.ok(this.noteService.save(note));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        if(this.noteService.exist(id)){
            this.noteService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }


}
