package cn.edu.zzuli.entity;

import javax.persistence.*;

/**
 * @author 程佩
 * @datatime 2019/5/14 14:22
 */
@Entity
@Table(name = "visits")
public class Visits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "visit_date")
    private String visitDate;

    @Column(name = "description")
    private String description;

    @JoinColumn(name = "pet_id")
    private Integer petId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
