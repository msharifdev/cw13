package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(
        name = Book.TABLE_NAME
)
public class Book {
    public static final String TABLE_NAME = "books";

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String author;

    @Column(nullable = false)
    private ZonedDateTime publishDate;

}
