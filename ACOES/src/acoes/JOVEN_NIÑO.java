/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

//import java.awt.Image;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author usuario
 */
@Entity
public class JOVEN_NIÑO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String Nombre; 
    private String Apellido1;
    private String Apellido2;
    private String Nacionalidad;
    private String Descripcion;
    //private Image imagen;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date FechaNacimiento;

    public CCJ getCcj() {
        return ccj;
    }

    public void setCcj(CCJ ccj) {
        this.ccj = ccj;
    }

    @ManyToOne
    private CCJ ccj;
    
    @ManyToOne
    private CASA_POPULORUM cp;
    
    @ManyToMany
    @JoinTable(
        name = "becas_obt", 
        joinColumns = @JoinColumn(name = "JOVEN_NIÑO_id"), 
        inverseJoinColumns = @JoinColumn(name = "BECA_id"))
    private List<BECA> becas;
    
    @ManyToOne
    private USUARIO padrino;
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public List<BECA> getBecas() {
        return becas;
    }

    public void setBecas(List<BECA> becas) {
        this.becas = becas;
    }

    public USUARIO getPadrino() {
        return padrino;
    }

    public void setPadrino(USUARIO padrino) {
        this.padrino = padrino;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String Apellido1) {
        this.Apellido1 = Apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String Apellido2) {
        this.Apellido2 = Apellido2;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JOVEN_NIÑO)) {
            return false;
        }
        JOVEN_NIÑO other = (JOVEN_NIÑO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acoes.JOVEN_NI\u00d1O[ id=" + id + " ]";
    }
    
}
