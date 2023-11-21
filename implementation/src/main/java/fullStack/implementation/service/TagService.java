package fullStack.implementation.service;

import fullStack.implementation.persistence.entity.Tag;
import fullStack.implementation.persistence.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getAll(){
        return this.tagRepository.findAll();
    }

    public Tag getTag(int id){
        return this.tagRepository.findById(id).orElse(null);
    }

    public Tag save (Tag tag){
        return this.tagRepository.save(tag);
    }

    public boolean exist(int id){
        return this.tagRepository.existsById(id);
    }

    public void delete(int id){
        this.tagRepository.deleteById(id);
    }
}
