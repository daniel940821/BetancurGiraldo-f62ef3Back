package fullStack.implementation.persistence.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="tag")
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tag",nullable = false, unique = true)
    private Integer idTag;
    @Column(length = 255,nullable = false)
    private String name;
    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime createdDate;

    @OneToMany (mappedBy = "tagNote",fetch =  FetchType.EAGER)
    private List<Note> tags;
}
