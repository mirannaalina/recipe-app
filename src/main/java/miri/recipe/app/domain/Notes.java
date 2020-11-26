package miri.recipe.app.domain;


import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class Notes {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;
    //large string objects
    @Lob
    private String recipeNotes;


}
