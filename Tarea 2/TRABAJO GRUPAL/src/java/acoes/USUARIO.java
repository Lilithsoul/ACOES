/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class USUARIO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;
    
    @Column (nullable = false)
    private String Nombre;
    @Column (nullable = false)
    private String Apellido1;
    private String Apellido2;
    @Column (nullable = false)
    private String email;
    private String Telefono;
    @Column (nullable = false)
    private String Password;
    @Column (nullable = false)
    private String NIF;
    @Column (nullable = false)
    private String User_name;
    @Temporal(TemporalType.DATE)
    @Column (nullable = false)
    private Date FechaNacimiento;

    public USUARIO(){
        
    }
    
    public USUARIO(String Nombre, String Apellido1, String Apellido2, String email, String Telefono, String Password, String NIF, String User_name, Date FechaNacimiento) {
        
        this.Nombre = Nombre;
        this.Apellido1 = Apellido1;
        this.Apellido2 = Apellido2;
        this.email = email;
        this.Telefono = Telefono;
        this.Password = Password;
        this.NIF = NIF;
        this.User_name = User_name;
        this.FechaNacimiento = FechaNacimiento;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String User_name) {
        this.User_name = User_name;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public Long getId() {
        return idUser;
    }

    public void setId(Long idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof USUARIO)) {
            return false;
        }
        USUARIO other = (USUARIO) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acoes.USUARIO[ id=" + idUser + " ]";
    }
    
}
