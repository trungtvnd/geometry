package uvsoftgroup.uvsoftgroupgeospatial.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
@EntityListeners(AuditingEntityListener.class)
public class Book {


    @Id
    @GeneratedValue
    private Long id;


    @Column(name = "author_id")
    private Long authorId;

    private String author;
    private String isbn;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private Author authorRe;

    @CreatedDate
    @Column(
            nullable = false,
            updatable = false
    )
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModified;


    @CreatedBy
    @Column(
            nullable = false,
            updatable = false
    )
    private Integer createdBy;

    @LastModifiedBy
    @Column(insertable = false)
    private Integer lastModifiedBy;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
