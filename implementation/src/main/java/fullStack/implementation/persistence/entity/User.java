package fullStack.implementation.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user",nullable = false, unique = true)
    private Integer idUsuario;
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    @Column(length = 50)
    private String password;
    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime createdDate;
    private boolean active=true;

    @OneToMany (mappedBy = "userNote",fetch =  FetchType.EAGER)
    private List<Note> notes;

}
