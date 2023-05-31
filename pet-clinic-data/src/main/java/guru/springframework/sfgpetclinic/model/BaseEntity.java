package guru.springframework.sfgpetclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    private Long id;//rekomendacja hibernate, by używać typów złożonych

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
