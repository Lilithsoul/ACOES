/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;


@Entity
public class JOVEN_NIÑO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column (nullable = false)
    private String Nombre; 
    @Column (nullable = false)
    private String Apellido1;
    private String Apellido2;
    @Column (nullable = false)
    private String Nacionalidad;
    
    @Column (nullable = false)
    private boolean apadrinado;

    private String Descripcion;
    //private Image imagen;
    //@Column (nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date FechaNacimiento;
    
    @OneToMany(mappedBy="niño_apadrinado")
    private List<HISTORIAL_APADRINAMIENTO> historiales_pertenecientes;
    
    @ManyToOne
    private CCJ ccj;
    
    @ManyToOne
    private CASA_POPULORUM cp;
    
    @OneToMany(mappedBy="niño_envio")
    private List<ENVIOS> envios_a_recibir;
    
    
    @ManyToMany
    @JoinTable(
        name = "becas_obt", 
        joinColumns = @JoinColumn(name = "JOVEN_NIÑO_id"), 
        inverseJoinColumns = @JoinColumn(name = "BECA_id"))
    private List<BECA> becas;
    
    public JOVEN_NIÑO() {
        
    }

    public JOVEN_NIÑO(String Nombre, String Apellido1, String Apellido2, String Nacionalidad, String Descripcion, Date FechaNacimiento, CCJ ccj) {
        
        this.Nombre = Nombre;
        this.ccj = ccj;
        this.Apellido1 = Apellido1;
        this.Apellido2 = Apellido2;
        this.Nacionalidad = Nacionalidad;
        this.Descripcion = Descripcion;
        this.FechaNacimiento = FechaNacimiento;
        apadrinado = false;
    }

    public boolean isApadrinado() {
        return apadrinado;
    }

    public void setApadrinado(boolean apadrinado) {
        this.apadrinado = apadrinado;
    }

    public List<HISTORIAL_APADRINAMIENTO> getHistoriales_pertenecientes() {
        return historiales_pertenecientes;
    }

    public void setHistoriales_pertenecientes(List<HISTORIAL_APADRINAMIENTO> historiales_pertenecientes) {
        this.historiales_pertenecientes = historiales_pertenecientes;
    }

    public List<ENVIOS> getEnvios_a_recibir() {
        return envios_a_recibir;
    }

    public void setEnvios_a_recibir(List<ENVIOS> envios_a_recibir) {
        this.envios_a_recibir = envios_a_recibir;
    }
            
    public CCJ getCcj() {
        return ccj;
    }

    public void setCcj(CCJ ccj) {
        this.ccj = ccj;
    }
    
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

    public CASA_POPULORUM getCp() {
        return cp;
    }

    public void setCp(CASA_POPULORUM cp) {
        this.cp = cp;
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
