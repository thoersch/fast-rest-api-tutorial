package tutorial.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @PrePersist
    public void onCreate() {
        created = Date.from(Instant.now());
    }

    @PreUpdate
    public void onModified() {
        modified = Date.from(Instant.now());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}