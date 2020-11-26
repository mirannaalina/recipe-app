package miri.recipe.app.domain;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uOom;


    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uOom) {
        this.description = description;
        this.amount = amount;
        this.uOom = uOom;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uOom, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.uOom = uOom;
        this.recipe=recipe;
    }

    public Ingredient(){

    }

}
