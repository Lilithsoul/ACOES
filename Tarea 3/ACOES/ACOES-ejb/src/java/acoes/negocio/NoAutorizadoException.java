/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.negocio;

/**
 *
 * @author sergo
 */
public class NoAutorizadoException extends ACOESException {

    /**
     * Creates a new instance of <code>NoSocioException</code> without detail
     * message.
     */
    public NoAutorizadoException() {
    }

    /**
     * Constructs an instance of <code>NoSocioException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NoAutorizadoException(String msg) {
        super(msg);
    }
}
