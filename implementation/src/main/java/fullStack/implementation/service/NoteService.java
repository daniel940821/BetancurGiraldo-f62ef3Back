package fullStack.implementation.service;

import fullStack.implementation.persistence.entity.Note;
import fullStack.implementation.persistence.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAll(){
        return this.noteRepository.findAll();
    }

    public Note getNote(int id){
        return this.noteRepository.findById(id).orElse(null);
    }

    public Note save (Note note){
        return this.noteRepository.save(note);
    }

    public boolean exist(int id){
        return this.noteRepository.existsById(id);
    }

    public void delete(int id){
        this.noteRepository.deleteById(id);
    }


}
