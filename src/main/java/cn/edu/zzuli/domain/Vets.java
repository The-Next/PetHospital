package cn.edu.zzuli.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;
/**
 * @author 程佩
 * @datatime 2019/5/14 14:30
 */
@Entity
@Table(name = "vets")
public class Vets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @JsonIgnoreProperties(value = "vetsList")
    @ManyToMany
    @JoinTable(name = "vets_specialties",joinColumns = @JoinColumn(name = "vets_id"),
    inverseJoinColumns = @JoinColumn(name = "specialties_id"))
    private List<Specialties> specialtiesList;
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

    public List<Specialties> getSpecialtiesList() {
        return specialtiesList;
    }

    public void setSpecialtiesList(List<Specialties> specialtiesList) {
        this.specialtiesList = specialtiesList;
    }
}
