/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



@Entity
@Inheritance( strategy = InheritanceType.JOINED )
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class USUARIO implements Serializable {
    
    @XmlTransient
    private static final long serialVersionUID = 1L;
    @Id
    private String User_name;
    
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
    @Temporal(TemporalType.DATE)
    @Column (nullable = false)
    private Date FechaNacimiento;

    private String num_cuenta_bancaria;
    
    private String direccion;
    
    @Column (nullable = false)
    private int apadrinados;
    
    private Role role = Role.USUARIO;
    
    @OneToMany(mappedBy="socio_envio")
    private List<ENVIOS> envios_enviados;
    
    @OneToMany(mappedBy="socio_apadrina")
    private List<HISTORIAL_APADRINAMIENTO> historiales_pert;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public String getNum_cuenta_bancaria() {
        return num_cuenta_bancaria;
    }

    public void setNum_cuenta_bancaria(String num_cuenta_bancaria) {
        this.num_cuenta_bancaria = num_cuenta_bancaria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getApadrinados() {
        return apadrinados;
    }

    public List<ENVIOS> getEnvios_enviados() {
        return envios_enviados;
    }

    public void setEnvios_enviados(List<ENVIOS> envios_enviados) {
        this.envios_enviados = envios_enviados;
    }

    public List<HISTORIAL_APADRINAMIENTO> getHistoriales_pert() {
        return historiales_pert;
    }

    public void setHistoriales_pert(List<HISTORIAL_APADRINAMIENTO> historiales_pert) {
        this.historiales_pert = historiales_pert;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public void setApadrinados(int apadrinados) {
        this.apadrinados = apadrinados;
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

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.User_name);
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
        final USUARIO other = (USUARIO) obj;
        if (!Objects.equals(this.User_name, other.User_name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "USUARIO{" + "User_name=" + User_name + ", Nombre=" + Nombre + ", Apellido1=" + Apellido1 + ", Apellido2=" + Apellido2 + '}';
    }

    
    
}
