/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;


@Entity
@PrimaryKeyJoinColumn(referencedColumnName="idUser")

public class ADMINISTRADOR extends USUARIO {
    
    @Column (nullable = false)
    private String num_SS;
    @Column (nullable = false)
    private String seccion_operativa;
    @Column (nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_Entrada;
    @Column (nullable = false)
    private double sueldo;
    @Column (nullable = false)
    private double importeBruto;
    
    public ADMINISTRADOR (){
        
    }

    public ADMINISTRADOR (String Nombre, String Apellido1, String Apellido2, String email, String Telefono, String Password, String NIF, String User_name, Date FechaNacimiento, String num_SS, Date fecha_Entrada, double sueldo, double importeBruto, String seccion_operativa) {
        
        super(Nombre, Apellido1, Apellido2, email, Telefono, Password, NIF, User_name,FechaNacimiento);
        this.num_SS = num_SS;
        this.fecha_Entrada = fecha_Entrada;
        this.sueldo = sueldo;
        this.importeBruto = importeBruto;
        this.seccion_operativa = seccion_operativa;
    }
    
    


    public String getNum_SS() {
        return num_SS;
    }

    public void setNum_SS(String num_SS) {
        this.num_SS = num_SS;
    }

    public String getSeccion_operativa() {
        return seccion_operativa;
    }

    public void setSeccion_operativa(String seccion_operativa) {
        this.seccion_operativa = seccion_operativa;
    }
    
    public Date getFecha_Entrada() {
        return fecha_Entrada;
    }

    public void setFecha_Entrada(Date fecha_Entrada) {
        this.fecha_Entrada = fecha_Entrada;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getImporteBruto() {
        return importeBruto;
    }

    public void setImporteBruto(double importeBruto) {
        this.importeBruto = importeBruto;
    }
    
}