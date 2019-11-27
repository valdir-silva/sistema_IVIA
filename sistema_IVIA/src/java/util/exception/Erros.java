/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.exception;

/**
 *
 * @author valdir.silva
 */
public class Erros extends Exception{
    
    public Erros(String message) {
        super(message);
    }

    public Erros(String message, Throwable cause) {
        super(message, cause);
    }
}
