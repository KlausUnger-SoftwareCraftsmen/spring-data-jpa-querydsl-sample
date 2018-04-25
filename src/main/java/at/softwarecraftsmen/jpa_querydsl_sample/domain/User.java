package at.softwarecraftsmen.jpa_querydsl_sample.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="users")
public class User extends AbstractPersistable<Long> {

    @Version
    private Integer version;

    private String firstName;

    private String lastName;

    protected User() {}

    public Integer getVersion() {
        return version;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }
}
