/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class CCJ implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column (nullable = false)
    private String Nombre;
    @Column (nullable = false)
    private String Region;
    @Column (nullable = false)
    private String Nacion;
    @Column (nullable = false)
    private String Direccion;
    @Column (nullable = false)
    private String Telefono;
    @Column (nullable = false)
    private String email;
    @Column (nullable = false)
    private String Descripcion;
    
    @OneToMany(mappedBy="ccj")
    private List<JOVEN_NIÑO> jovenes;
    
    public CCJ(){
        
    }

    public CCJ(String Nombre, String Nacion, String Region, String Direccion, String Telefono, String email, String Descripcion) {
        
        this.Nombre = Nombre;
        this.Nacion = Nacion;
        this.Region = Region;
        this.email = email;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Descripcion = Descripcion;
        
    }


    
    
    public List<JOVEN_NIÑO> getJovenes() {
        return jovenes;
    }

    public void setJovenes(List<JOVEN_NIÑO> jovenes) {
        this.jovenes = jovenes;
    }
    
    public String getNacion() {
        return Nacion;
    }

    public void setNacion(String Nacion) {
        this.Nacion = Nacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
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

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(object instanceof CCJ)) {
            return false;
        }
        CCJ other = (CCJ) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acoes.CCJ[ id=" + id + " ]";
    }
    
}
