/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import util.exception.Erros;

/**
 *
 * @author valdir.silva
 */
public interface CrudDAO<E> {
    
    public void salvar(E entidade) throws Erros;
    public void deletar(E entidade) throws Erros;
    public List<E> buscar() throws Erros;
    
}

