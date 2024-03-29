package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="specialties")
public class Specialty extends BaseEntity {

    @Column(name="description")
    private String description;


    @Builder
    public Specialty(Long id, String description) {
        super(id);
        this.description = description;
    }
}
