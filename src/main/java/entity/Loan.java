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


public class Loan extends BaseEntity<Integer>  {

    public static final String TABLE_NAME = "loans";




    @JoinColumn(name = "book_id")
    @ManyToOne
    private Book book;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private Member member;



    @Column(name = "due_date")
    private ZonedDateTime dueDate;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;
}













