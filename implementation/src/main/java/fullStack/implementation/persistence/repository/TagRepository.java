package fullStack.implementation.persistence.repository;

import fullStack.implementation.persistence.entity.Tag;
import org.springframework.data.repository.ListCrudRepository;

public interface TagRepository extends ListCrudRepository<Tag,Integer> {
}
