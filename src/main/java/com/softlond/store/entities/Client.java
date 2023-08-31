package com.softlond.store.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String adrress;

    // @ManyToOne
    // @JoinColumn(name = "category_id")
    // private Category category;

    // @ManyToOne
    // @JoinColumn(name = "product_id")
    // private Product product;

    public Client(String name, String email, String adrress) {
        this.name = name;
        this.email = email;
        this.adrress = adrress;
    }

}
