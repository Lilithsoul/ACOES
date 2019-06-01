/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.negocio;

import acoes.negocio.ACOESException;
import acoes.entidades.BECA;
import acoes.entidades.CASA_POPULORUM;
import acoes.entidades.CCJ;
import acoes.entidades.ENVIOS;
import acoes.entidades.HISTORIAL_APADRINAMIENTO;
import acoes.entidades.JOVEN_NIÑO;
import acoes.entidades.USUARIO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author francis
 */
@Local
public interface Negocio {
    public void registrarUsuario(USUARIO u)throws ACOESException;
    public void usuarioSocio(USUARIO u) throws ACOESException;
    //public void validarCuenta(String cuenta, String validacion) throws ACOESException;
    
    public void compruebaLogin(USUARIO u) throws ACOESException;
    
    public void compruebaLoginAdmin(USUARIO u) throws ACOESException;
    public void compruebaLoginSocio(USUARIO u) throws ACOESException;
    public void compruebaLoginSocioAdmin(USUARIO u) throws ACOESException;
    
    public USUARIO refrescarUsuario(USUARIO u) throws ACOESException;
    public void modificarEnvio(ENVIOS e, USUARIO u) throws ACOESException;
    public void insertarEnvio(ENVIOS e, USUARIO u)throws ACOESException;
    public void eliminarEnvio(ENVIOS e, USUARIO u)throws ACOESException;
    public void modificarBeca(BECA c, USUARIO u) throws ACOESException;
    public void insertarBeca(BECA c, USUARIO u)throws ACOESException;
    public void eliminarBeca(BECA c, USUARIO u)throws ACOESException;
    public List<BECA> obtenerBecas() throws ACOESException;
    public void modificarCCJ(CCJ c, USUARIO u) throws ACOESException;
    public void insertarCCJ(CCJ c, USUARIO u)throws ACOESException;
    public void eliminarCCJ(CCJ c, USUARIO u)throws ACOESException;
    public List<CCJ> obtenerCCJs(USUARIO u) throws ACOESException;
    public void modificarPopulorum(CASA_POPULORUM c, USUARIO u) throws ACOESException;
    public void insertarPopulorum(CASA_POPULORUM c, USUARIO u)throws ACOESException;
    public void eliminarPopulorum(CASA_POPULORUM c, USUARIO u)throws ACOESException;
    public List<CASA_POPULORUM> obtenerPopulorums() throws ACOESException;
    
    public List<JOVEN_NIÑO> obtenerNinios();

    public void eliminarNinio(JOVEN_NIÑO ni, USUARIO u) throws ACOESException;

    public void modificarNinio(JOVEN_NIÑO ninio, USUARIO u) throws ACOESException;

    public void insertarNinio(JOVEN_NIÑO ninio, USUARIO u) throws ACOESException;

    public List<HISTORIAL_APADRINAMIENTO> obtenerNiniosSocio(USUARIO u);

    public void insertarHistorial(HISTORIAL_APADRINAMIENTO historial, USUARIO u) throws ACOESException;

    public String getPadrinoNegocio(JOVEN_NIÑO n);

    public void insertarEnvioSocio(HISTORIAL_APADRINAMIENTO h, ENVIOS e, USUARIO u) throws ACOESException;

    public List<ENVIOS> obtenerEnviosSocio(USUARIO u);

    public CCJ getCCJID(Long id);

    public CASA_POPULORUM getCPID(Long populorum);

    public BECA getBecasID(Long beca);

    public List<ENVIOS> obtenerEnviosTotales();

    public List<HISTORIAL_APADRINAMIENTO> getHistorialesTotales();
    
    public JOVEN_NIÑO getNinioID(Long ninio);

    public USUARIO getSocioID(String socio);

    public void refrescarApadrinamientos(USUARIO u) throws ACOESException;

    public List<CCJ> CcjNinio(USUARIO u);

    public List<CASA_POPULORUM> PopulorumNinio(USUARIO u);

    public List<JOVEN_NIÑO> obtenerNiniosSinPadrino();

 
}
