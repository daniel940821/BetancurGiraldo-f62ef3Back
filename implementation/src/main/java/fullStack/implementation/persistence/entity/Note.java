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
@Table(name="note")
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_note",nullable = false, unique = true)
    private Integer idNote;
    @Column(length = 255,nullable = false)
    private String title;
    @Column(name="content",length = 255,nullable = false)
    private String contentNote;
    @Column (name = "id_user",nullable = false)
    private Integer idUser;
    @Column (name = "id_tag")
    private Integer idTag;
    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime createdDate;
    private boolean archived=false;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="id_user", referencedColumnName = "id_user",insertable = false, updatable = false)
    @JsonIgnore
    private User userNote;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="id_tag", referencedColumnName = "id_tag",insertable = false, updatable = false)
    @JsonIgnore
    private Tag tagNote;


}
