package kacper.car_app.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
//@Data - zamiast tostr, get,set, equalsandhash
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "login")
    private String login;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "number_phone")
    private String numberPhone;


}
