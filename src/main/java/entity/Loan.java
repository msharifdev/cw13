package entity;

import entity.enums.LoanStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(
        name = Loan.TABLE_NAME
)


public class Loan {

    public static final String TABLE_NAME = "loans";


    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "due_date")
    private ZonedDateTime dueDate;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;
}













