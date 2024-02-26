package dawp.practica01.domain;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "arbol")
public class Arbol implements Serializable {
    private static final long serialVersionUID = 1L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremental
    @Column(name = "id_arbol")
    private Long idArbol; //MySQL => id_arbol
    private String nombreCientifico; //MySQL => nombre_cientifico
    private Integer edad; //MySQL => edad
    private String rutaImagen; //MySQL => ruta_imagen
    private Boolean frutal; //MySQL => frutal

    //Constructores
    public Arbol() {
    }

    public Arbol(String nombreCientifico, Integer edad, String rutaImagen, Boolean frutal) {
        this.nombreCientifico = nombreCientifico;
        this.edad = edad;
        this.rutaImagen = rutaImagen;
        this.frutal = frutal;
    }
}
