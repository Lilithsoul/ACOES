/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author usuario
 */

@Entity(name = "becas")
@NamedQuery(name = BECA.FIND_ALL, query = "SELECT c from becas c ORDER BY c.Nombre ASC")
public class BECA implements Serializable {
    
    public static final String FIND_ALL = "BECA.findAll";
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column (nullable = false)
    private String Nombre;
    private String Descripcion;
    @Column (nullable = false)
    private int cuantia;
    @Column (nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date FechaEmision;
    @Column (nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date FechaFin;
    
    @ManyToMany(mappedBy = "becas")
    private List<JOVEN_NIÑO> niños;

    public BECA(){
        
    }
    
    public BECA(String Nombre, int cuantia, Date FechaEmision, Date FechaFin) {
        
        this.Nombre = Nombre;
        this.cuantia = cuantia;
        this.FechaEmision = FechaEmision;
        this.FechaFin = FechaFin;
    }
    
    

    public int getCuantia() {
        return cuantia;
    }

    public void setCuantia(int cuantia) {
        this.cuantia = cuantia;
    } 

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public List<JOVEN_NIÑO> getNiños() {
        return niños;
    }

    public void setNiños(List<JOVEN_NIÑO> niños) {
        this.niños = niños;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Date getFechaEmision() {
        return FechaEmision;
    }

    public void setFechaEmision(Date FechaEmision) {
        this.FechaEmision = FechaEmision;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Date FechaFin) {
        this.FechaFin = FechaFin;
    }

    public int getCuantía() {
        return cuantia;
    }

    public void setCuantía(int cuantía) {
        this.cuantia = cuantía;
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
        if (!(object instanceof BECA)) {
            return false;
        }
        BECA other = (BECA) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acoes.BECA[ id=" + id + " ]";
    }
    
}
