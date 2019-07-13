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
@Table(name = "KNOWLEDGE_TYPES")
public class KnowledgeTypeEntity {
    private long id;
    private String name;
    private Set<KnowledgeRepositoryEntity> knowledgeRepositoriesById;

    public KnowledgeTypeEntity() {
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
            KnowledgeTypeEntity that = (KnowledgeTypeEntity)o;
            return this.id == that.id && Objects.equals(this.name, that.name);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "knowledgeTypeByTypeId", fetch = FetchType.LAZY)
    public Set<KnowledgeRepositoryEntity> getKnowledgeRepositoriesById() {
        return this.knowledgeRepositoriesById;
    }

    public void setKnowledgeRepositoriesById(Set<KnowledgeRepositoryEntity> knowledgeRepositoriesById) {
        this.knowledgeRepositoriesById = knowledgeRepositoriesById;
    }
}
