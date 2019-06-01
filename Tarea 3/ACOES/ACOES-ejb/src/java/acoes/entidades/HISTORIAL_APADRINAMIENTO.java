/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;


@Entity
public class HISTORIAL_APADRINAMIENTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column (nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_inicio;
    @Column (nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_fin;
    
    @Column (nullable = false)
    private boolean apadrinado;
    
    @ManyToOne
    private JOVEN_NIÑO niño_apadrinado;
    
    @ManyToOne
    private USUARIO socio_apadrina;
    
    public boolean isApadrinado() {
        return apadrinado;
    }

    public void setApadrinado(boolean apadrinado) {
        this.apadrinado = apadrinado;
    }

    public JOVEN_NIÑO getNiño_apadrinado() {
        return niño_apadrinado;
    }

    public void setNiño_apadrinado(JOVEN_NIÑO niño_apadrinado) {
        this.niño_apadrinado = niño_apadrinado;
    }

    public USUARIO getSocio_apadrina() {
        return socio_apadrina;
    }

    public void setSocio_apadrina(USUARIO socio_apadrina) {
        this.socio_apadrina = socio_apadrina;
    }
    

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.niño_apadrinado);
        hash = 73 * hash + Objects.hashCode(this.socio_apadrina);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HISTORIAL_APADRINAMIENTO other = (HISTORIAL_APADRINAMIENTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    



    @Override
    public String toString() {
        return "acoes.HISTORIAL_APADRINAMIENTO[ id=" + id + " ]";
    }
    
}
