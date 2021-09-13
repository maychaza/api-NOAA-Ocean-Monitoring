package ar.com.ada.api.noaaboyas.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name= "boya")
public class Boya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "boya_id")
    private Integer boyaId;

    @Column(name= "color_luz")
    private Integer colorLuz;

    @Column(name= "longitud_instalacion")
    private Double longitudInstalacion;

    @Column(name= "latitud_instalacion")
    private Double latitudInstalacion;

    @OneToMany(mappedBy = "boya", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Muestra> muestras = new ArrayList<>();
    


    public Integer getBoyaId() {
        return boyaId;
    }

    public void setBoyaId(Integer boyaId) {
        this.boyaId = boyaId;
    }

    public Double getLongitudInstalacion() {
        return longitudInstalacion;
    }

    public void setLongitudInstalacion(Double longitudInstalacion) {
        this.longitudInstalacion = longitudInstalacion;
    }

    public Double getLatitudInstalacion() {
        return latitudInstalacion;
    }

    public void setLatitudInstalacion(Double latitudInstalacion) {
        this.latitudInstalacion = latitudInstalacion;
    }

    public List<Muestra> getMuestras() {
        return muestras;
    }

    public void setMuestras(List<Muestra> muestras) {
        this.muestras = muestras;
    }

    public EstadoColorEnum getColorLuz() {
        return EstadoColorEnum.parse(colorLuz);
    }

    public void setColorLuz(EstadoColorEnum colorLuz) {
        this.colorLuz = colorLuz.getValue();
    }


    public enum EstadoColorEnum {
        ROJO(1), AMARILLO(2), VERDE(3), AZUL(4);  

        private final Integer value;

        // NOTE: Enum constructor tiene que estar en privado
        private EstadoColorEnum(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public static EstadoColorEnum parse(Integer id) {
            EstadoColorEnum status = null; // Default
            for (EstadoColorEnum item : EstadoColorEnum.values()) {
                if (item.getValue().equals(id)) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }

    //bidireccional
    public void agregarMuestra(Muestra muestra){
        this.muestras.add(muestra);
    }
       
}
