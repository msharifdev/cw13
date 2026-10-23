package entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (
        name = Member.TABLE_NAME
)
public class Member extends BaseEntity<Integer>  {
    public static final String TABLE_NAME = "members";



    @Column(nullable = false, unique = true)
    private String username;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;



    @OneToMany(mappedBy = "loan")
    private Set<Loan> loans;

}
