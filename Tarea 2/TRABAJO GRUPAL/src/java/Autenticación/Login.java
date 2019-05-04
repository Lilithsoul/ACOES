/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Autenticación;

import acoes.ADMINISTRADOR;
import acoes.SOCIO;
import acoes.USUARIO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author francis
 */
@Named(value = "login")
@RequestScoped
public class Login {

    private String usuario;
    private String contrasenia;
    private List<USUARIO> usuarios;
    private List<SOCIO> socios;
    private List<ADMINISTRADOR> admins;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public List<USUARIO> getUsuarios() {
        return usuarios;
    }

    public List<SOCIO> getSocios() {
        return socios;
    }

    public List<ADMINISTRADOR> getAdmins() {
        return admins;
    }
    
    
    
    @Inject
    private ControlAutorizacion ctrl;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        usuarios = new ArrayList<USUARIO>();
        usuarios.add(new USUARIO("Igna", "Pa", "Gu", "igna@uma.es", "834534", "admin", "aijsdioa9", "Igna9", new Date(1999, 10, 19)));
        admins = new ArrayList<ADMINISTRADOR>();
        admins.add(new ADMINISTRADOR("Andrés", "Suárez", "Mediavilla", "and@uma.es", "9823423", "admin", "89374329", "Andres9", new Date(1999, 10, 19), "8397428932", new Date(2019, 10, 19), 1200, 1000, "Despacho"));
        socios = new ArrayList<SOCIO>();
        socios.add(new SOCIO("Sergio", "Gon", "Si", "ser@uma.es", "9823423", "admin", "8937435", "SG9", new Date(1999, 10, 19), "8397428932", "C/ Mi calle"));
    }

    public String autenticar() {
        
        for(int i = 0; i < admins.size(); i++){
            
            if(admins.get(i).getUser_name().equals(usuario)){
                if(admins.get(i).getPassword().equals(contrasenia)){
                    
                    ADMINISTRADOR usuario1 = admins.get(i);
                    
                    ctrl.setAdmin(usuario1);
                    return ctrl.home();
                    
                }
            }
        }
        
        for(int j = 0; j < socios.size(); j++){
            
            if(socios.get(j).getUser_name().equals(usuario)){
                if(socios.get(j).getPassword().equals(contrasenia)){
                    
                    SOCIO usuario2 = socios.get(j);
                    
                    ctrl.setSocio(usuario2);
                    return ctrl.home();
                    
                }
            }
        }
        
        for(int k = 0; k < usuarios.size(); k++){
            
            if(usuarios.get(k).getUser_name().equals(usuario)){
                if(usuarios.get(k).getPassword().equals(contrasenia)){
                    
                    USUARIO usuario3 = usuarios.get(k);
                    
                    ctrl.setUsuario(usuario3);
                    return ctrl.home();
                    
                }
            }
        }
        
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario especificado no existe o la constraseña es incorrecta", "El usuario especificado no existe o la constraseña es incorrecta"));
        
        
        
        return null;
    }
}
