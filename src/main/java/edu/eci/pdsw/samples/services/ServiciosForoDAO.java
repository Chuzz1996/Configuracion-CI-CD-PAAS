/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.EntradaForo;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.DaoEntradaForo;
import edu.eci.pdsw.samples.persistence.DaoFactory;
import edu.eci.pdsw.samples.persistence.DaoUsuario;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estudiante
 */
public class ServiciosForoDAO extends ServiciosForo{

    private DaoEntradaForo foros;
    private DaoFactory daoF;
    
    public ServiciosForoDAO(){
        try{
            InputStream input = getClass().getClassLoader().getResource("applicationconfig_1.properties").openStream();
            Properties properties=new Properties();
            properties.load(input);
            daoF = DaoFactory.getInstance(properties);
        }catch(IOException ex){
            Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<EntradaForo> consultarEntradasForo() throws ExcepcionServiciosForos {
        List<EntradaForo> EF = null;
        try{
            daoF.beginSession();
            foros = daoF.getDaoEntradaForo();
            EF = foros.loadAll();
        }catch(PersistenceException ex){
            Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosForos(ex.getMessage());
        }finally{
            try {
               daoF.endSession();
           } catch (PersistenceException ex) {
               Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, ex);
               throw new ExcepcionServiciosForos(ex.getMessage());
           }
        }return EF;
    }

    @Override
    public EntradaForo consultarEntradaForo(int id) throws ExcepcionServiciosForos {
        EntradaForo EF = null;
        try{
            daoF.beginSession();
            foros = daoF.getDaoEntradaForo();
            EF = foros.load(id);
        }catch(PersistenceException ex){
            Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosForos(ex.getMessage());
        }finally{
            try {
                daoF.endSession();
            } catch (PersistenceException ex) {
                Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new ExcepcionServiciosForos(ex.getMessage());
            }
        }return EF;
    }

    @Override
    public void registrarNuevaEntradaForo(EntradaForo f) throws ExcepcionServiciosForos {
        try{
            daoF.beginSession();
            foros = daoF.getDaoEntradaForo();
            foros.save(f);
            daoF.commitTransaction();
        }catch(PersistenceException ex){
            try{
                daoF.rollbackTransaction();
            }catch(PersistenceException e){
                Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
            Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosForos(ex.getMessage());
        }finally{
            try{
                daoF.endSession();
            }catch(PersistenceException ex){
                Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new ExcepcionServiciosForos(ex.getMessage());
            }
        }
    }

    @Override
    public void agregarRespuestaForo(int idforo, Comentario c) throws ExcepcionServiciosForos {
        try{
            daoF.beginSession();
            foros = daoF.getDaoEntradaForo();
            EntradaForo foroEntrada = foros.load(idforo);
            Set<Comentario> comentarios = foroEntrada.getRespuestas();
            comentarios.add(c);
            foroEntrada.setRespuestas(comentarios);
            foros.update(foroEntrada);
            daoF.commitTransaction();
        }catch(PersistenceException ex){
            try {
                daoF.rollbackTransaction();
            }catch (PersistenceException e) {
                Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
            Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosForos(ex.getMessage());
        }finally{
            try{
                daoF.endSession();
            }catch(PersistenceException ex){
                Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new ExcepcionServiciosForos(ex.getMessage());
            }
        }
    }

    @Override
    public Usuario consultarUsuario(String email) throws ExcepcionServiciosForos {
        Usuario user = null;
        try{
            daoF.beginSession();
            foros = daoF.getDaoEntradaForo();
            List<EntradaForo> tmp = foros.loadAll();
            for(EntradaForo p:tmp){
                if(p.getAutor().getEmail().equals(email)){
                    user = p.getAutor();
                    break;
                }
            }
        }catch(PersistenceException ex){
            try {
                daoF.rollbackTransaction();
            }catch (PersistenceException e) {
                Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
            Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosForos(ex.getMessage());
        }finally{
            try{
                daoF.endSession();
            }catch(PersistenceException ex){
                Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new ExcepcionServiciosForos(ex.getMessage());
            }
        }return user;
    }
    
}
