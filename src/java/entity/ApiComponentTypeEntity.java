package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "API_COMPONENT_TYPES")
public class ApiComponentTypeEntity {
    private long id;
    private String name;
    private Set<ApiComponentEntity> apiComponentsById;

    public ApiComponentTypeEntity() {
    }

    @Id
    @Column(name = "ID", nullable = false)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            ApiComponentTypeEntity that = (ApiComponentTypeEntity)o;
            return this.id == that.id && Objects.equals(this.name, that.name);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.name});
    }

    @JsonIgnore
    @OneToMany(mappedBy = "apiComponentTypeByTypeId", fetch = FetchType.LAZY)
    public Set<ApiComponentEntity> getApiComponentsById() {
        return this.apiComponentsById;
    }

    public void setApiComponentsById(Set<ApiComponentEntity> apiComponentsById) {
        this.apiComponentsById = apiComponentsById;
    }
}
