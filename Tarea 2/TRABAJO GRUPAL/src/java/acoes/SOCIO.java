/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="idUser")

public class SOCIO extends USUARIO {
    
    @Column (nullable = false)
    private String num_cuenta_bancaria;
    
    @Column (nullable = false)
    private String direccion;
    
    @Column (nullable = false)
    private int apadrinados;
    
    @OneToMany(mappedBy="socio_envio")
    private List<ENVIOS> envios_enviados;
    
    @OneToMany(mappedBy="socio_apadrina")
    private List<HISTORIAL_APADRINAMIENTO> historiales_pert;
    
    public SOCIO(){
        
    }

    public SOCIO(String Nombre, String Apellido1, String Apellido2, String email, String Telefono, String Password, String NIF, String User_name, Date FechaNacimiento, String num_cuenta_bancaria, String direccion) {
        
        super(Nombre, Apellido1, Apellido2, email, Telefono, Password, NIF, User_name, FechaNacimiento);
        this.num_cuenta_bancaria = num_cuenta_bancaria;
        this.direccion = direccion;
        this.apadrinados = 0;
    }

    public int getApadrinados() {
        return apadrinados;
    }

    public void setApadrinados(int apadrinados) {
        this.apadrinados = apadrinados;
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
    
    

    
    
}
