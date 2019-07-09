package entity;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(
    name = "API_COMPONENTS"
)
public class ApiComponentEntity {
    private long id;
    private long typeId;
    private String functionMacrotaxonomy;
    private String name;
    private ApiComponentTypeEntity apiComponentTypeByTypeId;

    public ApiComponentEntity() {
    }

    @Id
    @Column(
        name = "ID",
        nullable = false,
        precision = 0
    )
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(
        name = "TYPE_ID",
        nullable = false,
        precision = 0
    )
    public long getTypeId() {
        return this.typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(
        name = "FUNCTION_MACROTAXONOMY",
        nullable = false,
        length = 50
    )
    public String getFunctionMacrotaxonomy() {
        return this.functionMacrotaxonomy;
    }

    public void setFunctionMacrotaxonomy(String functionMacrotaxonomy) {
        this.functionMacrotaxonomy = functionMacrotaxonomy;
    }

    @Basic
    @Column(
        name = "NAME",
        nullable = true,
        length = 50
    )
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
            ApiComponentEntity that = (ApiComponentEntity)o;
            return this.id == that.id && this.typeId == that.typeId && Objects.equals(this.functionMacrotaxonomy, that.functionMacrotaxonomy) && Objects.equals(this.name, that.name);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.typeId, this.functionMacrotaxonomy, this.name});
    }

    @ManyToOne
    @JoinColumn(
        name = "TYPE_ID",
        referencedColumnName = "ID",
        nullable = false,
        insertable = false,
        updatable = false
    )
    public ApiComponentTypeEntity getApiComponentTypeByTypeId() {
        return this.apiComponentTypeByTypeId;
    }

    public void setApiComponentTypeByTypeId(ApiComponentTypeEntity apiComponentTypeByTypeId) {
        this.apiComponentTypeByTypeId = apiComponentTypeByTypeId;
    }
}
