/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdacoes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author katiucha
 */
@Entity
public class user implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String contraseña;
    private String doc_id;
    private String username;
    @Temporal(TemporalType.DATE)
    private Date fec_nac;
    
    /*private enum TipoUsuario{
        profesor, 
        usuario,
        admim
    }
    
    private TipoUsuario tipUser;*/
    
    public user(){
        
    } 
    
    public user(String nombre, String apellidos, String email, String contraseña, String username){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email=email;
        this.contraseña=contraseña;
        this.username=username;

       
    }
    public Long getId() {
        return id;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFec_nac(Date fec_nac) {
        this.fec_nac = fec_nac;
    }
    
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getDoc_id() {
        return doc_id;
    }

    public String getUsername() {
        return username;
    }

    public Date getFec_nac() {
        return fec_nac;
    }
    
    
    
    public void setNombre(String nombre){
        this.nombre = nombre;
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
        if (!(object instanceof user)) {
            return false;
        }
        user other = (user) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdacoes.user[ id=" + id + " ]";
    }
    
}
