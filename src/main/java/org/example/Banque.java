package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
public final class Banque {
    private int id;
    @Getter
    @Setter
    private String pays;

}
