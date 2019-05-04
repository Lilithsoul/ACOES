/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class ENVIOS implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String Descripcion;
    
    @Column(nullable=false)
    private String Estado;
    
    @ManyToOne  // olsdkfosdfk
    private JOVEN_NIÑO niño_envio;
    
    @ManyToOne  // uiashdiuas
    private SOCIO socio_envio;
    
    public ENVIOS(){
        
    }
    
    public ENVIOS(String Descripcion, String Estado, JOVEN_NIÑO niño_envio, SOCIO socio_envio) {
        
        this.Descripcion = Descripcion;
        this.Estado = Estado;
        this.niño_envio = niño_envio;
        this.socio_envio = socio_envio;
    }
    
    

    public JOVEN_NIÑO getNiño_envio() {
        return niño_envio;
    }

    public void setNiño_envio(JOVEN_NIÑO niño_envio) {
        this.niño_envio = niño_envio;
    }

    public SOCIO getSocio_envio() {
        return socio_envio;
    }

    public void setSocio_envio(SOCIO socio_envio) {
        this.socio_envio = socio_envio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
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
        if (!(object instanceof ENVIOS)) {
            return false;
        }
        ENVIOS other = (ENVIOS) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acoes.ENVIOS[ id=" + id + " ]";
    }
    
}
