package cn.edu.zzuli.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * @author 程佩
 * @datatime 2019/5/14 14:32
 */
@Entity
@Table(name = "specialties")
public class Specialties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @JsonIgnoreProperties(value = "specialtiesList")
    @ManyToMany(mappedBy = "specialtiesList")
    private List<Vets> vetsList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vets> getVetsList() {
        return vetsList;
    }

    public void setVetsList(List<Vets> vetsList) {
        this.vetsList = vetsList;
    }
}
