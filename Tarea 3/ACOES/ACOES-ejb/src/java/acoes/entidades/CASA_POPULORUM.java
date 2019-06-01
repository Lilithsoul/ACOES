/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author usuario
 */

@Entity(name = "populorums")
@NamedQuery(name = CASA_POPULORUM.FIND_ALL, query = "SELECT c from populorums c ORDER BY c.Nombre ASC")
public class CASA_POPULORUM implements Serializable {
    
    public static final String FIND_ALL = "CASA_POPULORUM.findAll";
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (nullable = false)
    private String Nombre;
    @Column (nullable = false)
    private String Region;
    @Column (nullable = false)
    private int Tam_max;
    
    //@Column (nullable = false)
    @OneToMany(mappedBy="cp")
    private List<JOVEN_NIÑO> jovenes;

    public CASA_POPULORUM() {
    }
    
    

    public CASA_POPULORUM(String Nombre, String Region, int Tam_max) {
        this.Nombre = Nombre;
        this.Region = Region;
        this.Tam_max = Tam_max;
    }
    
    
    
    public List<JOVEN_NIÑO> getJovenes() {
        return jovenes;
    }

    public void setJovenes(List<JOVEN_NIÑO> jovenes) {
        this.jovenes = jovenes;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public int getTam_max() {
        return Tam_max;
    }

    public void setTam_max(int Tam_max) {
        this.Tam_max = Tam_max;
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
        if (!(object instanceof CASA_POPULORUM)) {
            return false;
        }
        CASA_POPULORUM other = (CASA_POPULORUM) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acoes.CASA_POPULORUM[ id=" + id + " ]";
    }
    
}