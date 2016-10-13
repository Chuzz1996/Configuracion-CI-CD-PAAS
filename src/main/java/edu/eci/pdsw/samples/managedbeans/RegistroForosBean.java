/*  
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.managedbeans;
    

import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.EntradaForo;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServiciosForos;
import edu.eci.pdsw.samples.services.ServiciosForo;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.*;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Felipe Losada
 */
@ManagedBean(name="RegistroBean")
@SessionScoped
public class RegistroForosBean implements Serializable{
    
    public static ServiciosForo sp=ServiciosForo.getInstance();
    
    private EntradaForo selectForo;
    
    public int ano;
    public int mes;
    public int idforo;
    
    public String NombreUsuario;
    public String CorreoUsuario;
    public String comentario;
    public String titulo;
    public String contenido;

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public EntradaForo entrada;
    private Set<Comentario> respuesta;

    public Set<Comentario> getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Set<Comentario> respuesta) {
        this.respuesta = respuesta;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public String getNombreUsuario(){
        return NombreUsuario;
    }
    
    public void setNombreUsuario(String usu){
        this.NombreUsuario = usu;
    }
    
    public String getCorreoUsuario(){
        return CorreoUsuario;
    }
    
    public void setCorreoUsuario(String usu){
        this.CorreoUsuario = usu;
    }


    public EntradaForo getEntrada() {
        return entrada;
    }

    public void setEntrada(EntradaForo entrada) {
        this.entrada = entrada;
    }

    public int getIdforo() {
        return idforo;
    }

    public void setIdforo(int idforo) {
        this.idforo = idforo;
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }
    public int dia;

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }
    public Usuario autor;
    
    
    public void setSp(ServiciosForo sp){
        this.sp = sp;
    }
    
    public List<EntradaForo> getSp(){
        try{
            return sp.consultarEntradasForo();
        }catch(ExcepcionServiciosForos ex){
            return null;
        }
    }
    
    public EntradaForo getSelectForo() {
        try{
            return sp.consultarEntradaForo(this.idforo);
        }catch(ExcepcionServiciosForos ex){
            return null;
        }
    }
    
    public void setSelectForo(EntradaForo selectedForo) {
        this.selectForo = selectedForo;
    }
    public void agregarForo(){
        Calendar fecha = new GregorianCalendar();
        java.util.Date JulianPuta  = fecha.getTime();
        if(CorreoUsuario.length()>0 && NombreUsuario.length()>0 && titulo.length()>0 && comentario.length()>0){
            Usuario nuevoUsuario = new Usuario(CorreoUsuario,NombreUsuario);
            try{
                EntradaForo ef = new EntradaForo(sp.consultarEntradasForo().size(),nuevoUsuario,titulo,comentario,new Date(JulianPuta.getTime()));
                sp.registrarNuevaEntradaForo(ef);
            }catch(ExcepcionServiciosForos ex){

            }
        }
    }
     public Set<Comentario> getRespuestas() {

        return respuesta;

    }
     
    public void cargeForo() {
        try{
            entrada=sp.consultarEntradaForo(this.idforo);
            respuesta=entrada.getRespuestas();
        }catch(ExcepcionServiciosForos ex){
           
        }
    }
     
     public void agregarRespuesta() {
        Calendar fecha = new GregorianCalendar();
        java.util.Date fechaYhora = fecha.getTime();
        try{
            sp.agregarRespuestaForo(idforo,new Comentario(new Usuario(CorreoUsuario,NombreUsuario),contenido ,new Date(fechaYhora.getTime())));
        }catch(ExcepcionServiciosForos ex){
           
        }
    }
    
}
