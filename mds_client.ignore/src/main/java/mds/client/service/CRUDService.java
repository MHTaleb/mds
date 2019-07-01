/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mds.client.service;

/**
 *
 * @author taleb
 */

public interface CRUDService<T> {
    
    public T createEntity(T entity);
    public T editEntity(Long id , T entity);
    public T findEntity(Long id );
    public void removeEntity(Long id);
    
    
}
