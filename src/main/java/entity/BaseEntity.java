package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity<ID extends Number> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  ID id;


}
