package cn.edu.zzuli.domain;
import javax.persistence.*;
import java.io.Serializable;
/**
 * @author 程佩
 * @datatime 2019/5/14 10:12
 */
@Entity
@Table(name = "Employ")
public class Employ implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private  String password;
    @Column(name = "isactive")
    private Integer isactive;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer is_active) {
        this.isactive = is_active;
    }
}
