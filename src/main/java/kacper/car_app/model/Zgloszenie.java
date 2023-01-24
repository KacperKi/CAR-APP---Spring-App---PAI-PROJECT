package kacper.car_app.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Entity
@Table(name = "zgloszenia")
public class Zgloszenie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "status")
    private String status = "";

//    @Pattern(regexp = "[a-zA-Z0-9\.\,\-]{10,500}", message="Niepoprawny opis zgłoszenia!")
    @Column(name = "opis")
    @NotEmpty(message = "Opis nie może być pusty!")
    private String opis;

    @Pattern(regexp = "[a-zA-Z\\s]{2,20}", message="Niepoprawna marka!")
    @Column(name = "marka")
    private String marka;

    @Pattern(regexp = "[a-zA-Z0-9\\s]{2,30}", message="Niepoprawny model!")
    @Column(name = "model")
    private String model;

    @Pattern(regexp = "[a-zA-ZAaĄąBbCcĆćDdEeĘęFfGgHhIiJjKkLlŁłMmNnŃńOoÓóPpRrSsŚśTtUuWwYyZzŹźŻż\\s]{2,20}", message="Niepoprawny typ!")
    @Column(name = "typ")
    private String typ;

    @Pattern(regexp = "[0-9]{9,11}", message="Podaj poprawny telefon")
    @Column(name = "telefon")
    private String telefon;


    public Zgloszenie(long id, String status, String opis, String marka, String model, String typ, String telefon) {
        this.id = id;
        this.status = status;
        this.opis = opis;
        this.marka = marka;
        this.model = model;
        this.typ = typ;
        this.telefon = telefon;
    }

    public Zgloszenie() {
    }


}
