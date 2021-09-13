package ar.com.ada.api.noaaboyas.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name= "muestra")
public class Muestra {

    //@NaturalId?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "muestra_id")
    private Integer muestraId;

    @ManyToOne
    @JoinColumn(name= "boya_id", referencedColumnName = "boya_id")
    private Boya boya;

    @Column(name= "horario_muestra")
    private Date horarioMuestra;

    @Column(name= "matricula_embarcacion")
    private String matriculaEmbarcacion;
    
    private Double longitud;
    
    private Double latitud;

    @Column(name= "altura_nivel_mar")
    private Double alturaNivelMar;



    public Integer getMuestraId() {
        return muestraId;
    }

    public void setMuestraId(Integer muestraId) {
        this.muestraId = muestraId;
    }

    public Date getHorarioMuestra() {
        return horarioMuestra;
    }

    public void setHorarioMuestra(Date horarioMuestra) {
        this.horarioMuestra = horarioMuestra;
    }

    public String getMatriculaEmbarcacion() {
        return matriculaEmbarcacion;
    }

    public void setMatriculaEmbarcacion(String matriculaEmbarcacion) {
        this.matriculaEmbarcacion = matriculaEmbarcacion;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getAlturaNivelMar() {
        return alturaNivelMar;
    }

    public void setAlturaNivelMar(Double alturaNivelMar) {
        this.alturaNivelMar = alturaNivelMar;
    }

    public Boya getBoya() {
        return boya;
    }

    //relacion bidireccional
    public void setBoya(Boya boya) {
        this.boya = boya;
        this.boya.agregarMuestra(this);
    }
    
    
    
}