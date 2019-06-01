/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.negocio;

import acoes.entidades.BECA;
import acoes.entidades.CASA_POPULORUM;
import acoes.entidades.CCJ;
import acoes.entidades.ENVIOS;
import acoes.entidades.Estado;
import acoes.entidades.HISTORIAL_APADRINAMIENTO;
import acoes.entidades.JOVEN_NIÑO;
import acoes.entidades.Role;
import acoes.entidades.USUARIO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author francis
 */
@Stateless
public class NegocioImpl implements Negocio {

    //private static final int TAM_CADENA_VALIDACION = 20;

    //@Resource(name = "mail/agenda")
    //private Session session;

    @PersistenceContext(unitName = "ACOESPU")
    private EntityManager em;


    @Override
    public void registrarUsuario(USUARIO u) throws ACOESException {
        USUARIO user = em.find(USUARIO.class, u.getUser_name());
        if (user != null) {
            // El usuario ya existe
            throw new CuentaRepetidaException();
        }


        em.persist(u);

    }
    
    @Override
    public void compruebaLogin(USUARIO u) throws ACOESException {
        USUARIO user = em.find(USUARIO.class, u.getUser_name());
        if (user == null) {
            throw new CuentaInexistenteException();
        }

        if (!user.getPassword().equals(u.getPassword())) {
            throw new ContraseniaInvalidaException();
        }
    }
    
    @Override
    public void compruebaLoginSocio(USUARIO u) throws ACOESException {
        USUARIO user = em.find(USUARIO.class, u.getUser_name());
        if (user == null) {
            throw new CuentaInexistenteException();
        }

        if (!user.getPassword().equals(u.getPassword())) {
            throw new ContraseniaInvalidaException();
        }
        if (user.getRole() != Role.SOCIO){
            throw new NoAutorizadoException();
        }
    }
    
    @Override
    public void compruebaLoginAdmin(USUARIO u) throws ACOESException {
        USUARIO user = em.find(USUARIO.class, u.getUser_name());
        if (user == null) {
            throw new CuentaInexistenteException();
        }

        if (!user.getPassword().equals(u.getPassword())) {
            throw new ContraseniaInvalidaException();
        }
        if (user.getRole() != Role.ADMINISTRADOR){
            throw new NoAutorizadoException();
        }
    }
    
    @Override
    public void compruebaLoginSocioAdmin(USUARIO u) throws ACOESException {
        USUARIO user = em.find(USUARIO.class, u.getUser_name());
        if (user == null) {
            throw new CuentaInexistenteException();
        }

        if (!user.getPassword().equals(u.getPassword())) {
            throw new ContraseniaInvalidaException();
        }
        if (user.getRole() != Role.SOCIO && user.getRole() != Role.ADMINISTRADOR){
            throw new NoAutorizadoException();
        }
    }

    @Override
    public USUARIO refrescarUsuario(USUARIO u) throws ACOESException {
        compruebaLogin(u);
        USUARIO user = em.find(USUARIO.class, u.getUser_name());
        em.refresh(user);
        return user;

    }
    
    @Override
    public void usuarioSocio(USUARIO u) throws ACOESException {
        compruebaLogin(u);
        em.merge(u);
    }
    
    @Override
    public void modificarCCJ(CCJ c, USUARIO u) throws ACOESException{
        
        compruebaLoginAdmin(u);
        em.merge(c);
    }

    @Override
    public void insertarCCJ(CCJ c, USUARIO u) throws ACOESException{
        
        compruebaLoginAdmin(u);
        em.persist(c);
    }

    @Override
    public CCJ getCCJID(Long id) {
        
        CCJ res = em.find(CCJ.class, id);
        if(res != null){
            return res;
        }
        return null;
    }  
    
    @Override
    public void eliminarCCJ(CCJ c, USUARIO u) throws ACOESException{
        
        compruebaLoginAdmin(u);
        em.remove(em.merge(c));
    }
    
    @Override
    public List<CCJ> obtenerCCJs(USUARIO u) throws ACOESException{
        
        return em.createNamedQuery(CCJ.FIND_ALL, CCJ.class).getResultList();
    }
    
    @Override
    public void modificarPopulorum(CASA_POPULORUM c, USUARIO u) throws ACOESException{
        
        compruebaLoginAdmin(u);
        em.merge(c);
    }

    @Override
    public void insertarPopulorum(CASA_POPULORUM c, USUARIO u) throws ACOESException{
        
        compruebaLoginAdmin(u);
        em.persist(c);
    }

    @Override
    public void eliminarPopulorum(CASA_POPULORUM c, USUARIO u) throws ACOESException{
        
        compruebaLoginAdmin(u);
        em.remove(em.merge(c));
    }
    
    @Override
    public List<CASA_POPULORUM> obtenerPopulorums() throws ACOESException{
        
        //TypedQuery<CCJ> query = em.createNamedQuery(CCJ.FIND_ALL, CCJ.class);
        //return query.getResultList(); 
        
        return em.createNamedQuery(CASA_POPULORUM.FIND_ALL, CASA_POPULORUM.class).getResultList();
    }
    
    @Override
    public void modificarBeca(BECA c, USUARIO u) throws ACOESException{
        
        compruebaLoginAdmin(u);
        em.merge(c);
    }

    @Override
    public void insertarBeca(BECA c, USUARIO u) throws ACOESException{
        
        compruebaLoginAdmin(u);
        em.persist(c);
    }

    @Override
    public void eliminarBeca(BECA c, USUARIO u) throws ACOESException{
        
        compruebaLoginAdmin(u);
        em.remove(em.merge(c));
    }
    
    @Override
    public List<BECA> obtenerBecas() throws ACOESException{
        
        //TypedQuery<CCJ> query = em.createNamedQuery(CCJ.FIND_ALL, CCJ.class);
        //return query.getResultList(); 
        
        return em.createNamedQuery(BECA.FIND_ALL, BECA.class).getResultList();
    }

    @Override
    public CASA_POPULORUM getCPID(Long populorum) {
        
        CASA_POPULORUM res = em.find(CASA_POPULORUM.class, populorum);
        if(res != null){
            return res;
        }
        return null;
    }

    @Override
    public BECA getBecasID(Long beca) {
        
        BECA b = em.find(BECA.class, beca);
        if(b != null){
        return b;
        }
        return null;
    }
    
    

    @Override
    public void modificarEnvio(ENVIOS e, USUARIO u) throws ACOESException{
        
        compruebaLoginAdmin(u);
        em.merge(e);
    }

    
    @Override
    public void insertarEnvio(ENVIOS e, USUARIO u) throws ACOESException{
        Query selectQuery = em.createQuery("select q from HISTORIAL_APADRINAMIENTO q where q.niño_apadrinado.id = :id and q.apadrinado = 1 and q.socio_apadrina.User_name = :name",HISTORIAL_APADRINAMIENTO.class);
        selectQuery.setParameter("id", e.getNiño_envio().getId());
        selectQuery.setParameter("name", e.getSocio_envio().getUser_name());
        if(!selectQuery.getResultList().isEmpty()){
        compruebaLoginSocioAdmin(u);
        e.setEstado(Estado.PENDIENTE);
        e.setNiño_envio(e.getNiño_envio());
        e.setSocio_envio(e.getSocio_envio());
        em.persist(e);
    }
    }

    @Override
    public void insertarEnvioSocio(HISTORIAL_APADRINAMIENTO h, ENVIOS e, USUARIO u) throws ACOESException{

        compruebaLoginAdmin(u);
        e.setEstado(Estado.PENDIENTE);
        e.setNiño_envio(h.getNiño_apadrinado());
        e.setSocio_envio(h.getSocio_apadrina());
            
        em.persist(e);
        
    }

 
    @Override
    public void eliminarEnvio(ENVIOS e, USUARIO u) throws ACOESException{
        
        compruebaLoginAdmin(u);
        em.remove(em.merge(e));
    

    }

    @Override
    public void eliminarNinio(JOVEN_NIÑO ni, USUARIO u) throws ACOESException {
        
        compruebaLoginAdmin(u);
        em.remove(em.merge(ni));

    }

    @Override
    public void modificarNinio(JOVEN_NIÑO ninio, USUARIO u) throws ACOESException {
     
        compruebaLoginAdmin(u);
        
        em.merge(ninio);

        
    }

    @Override
    public void insertarNinio(JOVEN_NIÑO ninio, USUARIO u) throws ACOESException{
        
        compruebaLoginAdmin(u);
        em.persist(ninio);

    }
    @Override
    public List<JOVEN_NIÑO> obtenerNinios(){     
        
        return em.createQuery("SELECT c FROM JOVEN_NIÑO c", JOVEN_NIÑO.class).getResultList();
    }

    @Override
    public List<HISTORIAL_APADRINAMIENTO> obtenerNiniosSocio(USUARIO u) {
        USUARIO user = em.find(USUARIO.class, u.getUser_name());
      
        return user.getHistoriales_pert();
    }

    @Override
    public List<HISTORIAL_APADRINAMIENTO> getHistorialesTotales() {
        Query selectQuery = em.createQuery("select q from HISTORIAL_APADRINAMIENTO q where q.apadrinado = 1", HISTORIAL_APADRINAMIENTO.class);
        return selectQuery.getResultList();
    }

    
    
    @Override
    public void insertarHistorial(HISTORIAL_APADRINAMIENTO historial, USUARIO u) throws ACOESException {
        try{
        Query selectQuery = em.createQuery("select q from JOVEN_NIÑO q where q.apadrinado = 0", JOVEN_NIÑO.class);
        selectQuery.setMaxResults(1);
        JOVEN_NIÑO n = (JOVEN_NIÑO)selectQuery.getSingleResult();

        historial.setNiño_apadrinado(n);
        n.setApadrinado(true);
        
        u = historial.getSocio_apadrina();
        u.setApadrinados(u.getApadrinados()+1);
        
        Calendar cal = Calendar.getInstance();
        Date fechaInicio = cal.getTime();
        cal.add(Calendar.MONTH, 6);
        Date fechaFin = cal.getTime();
        historial.setFecha_inicio(fechaInicio);
        historial.setFecha_fin(fechaFin);
        historial.setApadrinado(true);
        em.merge(u);
        em.merge(n);
        em.persist(historial);
        }catch (Exception e){
            try {
                throw new Exception(e.getCause());
            } catch (Exception ex) {
                Logger.getLogger(NegocioImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
  
        }
    }

    @Override
    public List<ENVIOS> obtenerEnviosSocio(USUARIO u) {
        USUARIO user = em.find(USUARIO.class, u.getUser_name());
      
        return user.getEnvios_enviados();
    }

    @Override
    public String getPadrinoNegocio(JOVEN_NIÑO n) {
        if(n.isApadrinado()){
        Query selectQuery = em.createQuery("select q from HISTORIAL_APADRINAMIENTO q "
            + "where q.niño_apadrinado.id = :id and q.apadrinado = 1",
            HISTORIAL_APADRINAMIENTO.class);
        
        selectQuery.setParameter("id", n.getId());
        HISTORIAL_APADRINAMIENTO res = (HISTORIAL_APADRINAMIENTO)selectQuery.getSingleResult();
        USUARIO u = res.getSocio_apadrina();
        
        return u.getUser_name();
        
        }
        return "No";
    }

    @Override
    public List<ENVIOS> obtenerEnviosTotales() {
        Query selectQuery = em.createQuery("select q from ENVIOS q ", ENVIOS.class);
        return selectQuery.getResultList();
        
    }
    
    @Override
    public void refrescarApadrinamientos(USUARIO u) throws ACOESException{
        
        compruebaLoginSocio(u);
        
        List<HISTORIAL_APADRINAMIENTO> h = em.createQuery("select q from HISTORIAL_APADRINAMIENTO q ",
        HISTORIAL_APADRINAMIENTO.class).getResultList();
        
        Calendar cal = Calendar.getInstance();
        Date fechaHoy = cal.getTime();
        
        for (HISTORIAL_APADRINAMIENTO hist : h) {
                if(fechaHoy.compareTo(hist.getFecha_fin())>0){
                    hist.setApadrinado(false);
                    hist.getNiño_apadrinado().setApadrinado(false);
                    hist.getSocio_apadrina().setApadrinados(hist.getSocio_apadrina().getApadrinados()-1);
                    em.merge(hist.getNiño_apadrinado());
                    em.merge(hist.getSocio_apadrina());
                    em.merge(hist);
                    
                }
        }
    }
    
    @Override
    public List<CCJ> CcjNinio(USUARIO u){
        List<HISTORIAL_APADRINAMIENTO> h = u.getHistoriales_pert();
        List<CCJ> c = new ArrayList<>();
        for (HISTORIAL_APADRINAMIENTO hist : h) {
            if(hist.getNiño_apadrinado().getCcj() != null){
                if(!c.contains(hist.getNiño_apadrinado().getCcj())){
                    c.add(hist.getNiño_apadrinado().getCcj());
                }
            }
        }
        if(c.isEmpty()){
            return null;
        }
        return c;
        
    }
    
    @Override
    public List<CASA_POPULORUM> PopulorumNinio(USUARIO u){
        List<HISTORIAL_APADRINAMIENTO> h = u.getHistoriales_pert();
        List<CASA_POPULORUM> c = new ArrayList<>();
        for (HISTORIAL_APADRINAMIENTO hist : h) {
             if(hist.getNiño_apadrinado().getCp() != null){
                if(!c.contains(hist.getNiño_apadrinado().getCp())){
                    c.add(hist.getNiño_apadrinado().getCp());
                }
             }
        }
        if(c.isEmpty()){
            return null;
        }
        return c;
        
    }

        @Override
    public USUARIO getSocioID(String socio) {
        USUARIO res = em.find(USUARIO.class, socio);
        if(res != null){
        return res;
        }
        return null;
    }
    @Override
    public JOVEN_NIÑO getNinioID(Long ninio){
        JOVEN_NIÑO res = em.find(JOVEN_NIÑO.class, ninio);
        if(res != null){
        return res;
        }
        return null;
    }

    @Override
    public List<JOVEN_NIÑO> obtenerNiniosSinPadrino() {
        return em.createQuery("SELECT c FROM JOVEN_NIÑO c where c.apadrinado = 0", JOVEN_NIÑO.class).getResultList();
    }

    
}
