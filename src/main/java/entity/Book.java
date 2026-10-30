package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = Book.TABLE_NAME
)
public class Book extends BaseEntity<Integer> {
    public static final String TABLE_NAME = "books";





    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String author;

    @Column(nullable = false)
    private ZonedDateTime publishDate;

    @OneToMany(mappedBy = "book")
    private Set<Loan> loans;

    @Column(nullable = false,length = 20)
    private String isbn;

}
