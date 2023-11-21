package fullStack.implementation.persistence.repository;

import fullStack.implementation.persistence.entity.Note;
import org.springframework.data.repository.ListCrudRepository;

public interface NoteRepository extends ListCrudRepository<Note,Integer> {
}
