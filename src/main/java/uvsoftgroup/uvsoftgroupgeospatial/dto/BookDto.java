package uvsoftgroup.uvsoftgroupgeospatial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {


    private Long id;


    private String author;
    private Long authorId;
    private String authorName;
    private String isbn;

    private LocalDateTime createDate;
    private LocalDateTime lastModified;


    private Integer createdBy;

    private Integer lastModifiedBy;

    public BookDto(Long id, String author, Long authorId, String authorName) {
        this.id = id;
        this.author = author;
        this.authorId = authorId;
        this.authorName = authorName;
    }
}
