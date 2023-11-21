package fullStack.implementation.web.controller;

import fullStack.implementation.persistence.entity.Tag;
import fullStack.implementation.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tag")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public ResponseEntity<List<Tag>> getAll(){
        return ResponseEntity.ok(this.tagService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTag(@PathVariable("id") int id){
        return ResponseEntity.ok(this.tagService.getTag(id));
    }

    @PostMapping
    public ResponseEntity<Tag> save (@RequestBody Tag tag){
        if(tag.getIdTag() == null || !this.tagService.exist(tag.getIdTag())){
            return ResponseEntity.ok(this.tagService.save(tag));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Tag> update(@RequestBody Tag tag){
        if(tag.getIdTag()!= null && this.tagService.exist(tag.getIdTag())){
            return ResponseEntity.ok(this.tagService.save(tag));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        if(this.tagService.exist(id)){
            this.tagService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
