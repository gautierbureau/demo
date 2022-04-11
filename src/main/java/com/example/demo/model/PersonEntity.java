package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    // @ManyToOne
    // @JoinColumn(name = "address", foreignKey = @ForeignKey(name = "address_person_fk"), referencedColumnName = "idAddress")
    // private AddressEntity address;

}
