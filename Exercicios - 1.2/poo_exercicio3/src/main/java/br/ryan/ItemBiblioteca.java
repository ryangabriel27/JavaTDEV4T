package br.ryan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class ItemBiblioteca {
    private String titulo;
    private String autor;
   
    public abstract void emprestar();
}
