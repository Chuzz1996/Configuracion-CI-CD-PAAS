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
package edu.eci.pdsw.samples.tests;
import edu.eci.pdsw.samples.services.*;
import edu.eci.pdsw.samples.entities.*;
import java.util.Date;
import edu.eci.pdsw.samples.entities.*;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Felipe Losada
 */
/**
 * CLASE 1: El comentario tiene asociado un usuario,
 * y es agregado correctamente.
 * Falla: No
 * Nombre: ComentarioAgregadoExitoso
 * 
 * CLASE 2: El comentario no tiene asociado un un usuario,
 * y no es agregado correctamente.
 * Falla: Si
 * Nombre: ComentarioNoAgregado
 * 
 * 
 * CLASE 3: El usuario que agrega el comentario tiene la
 * fecha actual
 * Frontera: No
 * Falla: No
 * Nombre: ComentarioFechaActual
 * 
 * CLASE 4: El usuario que agrega el comentario tiene una
 * fecha menor a la actual
 * Frontera: No
 * Falla: Si
 * Nombre: ComentarioFechaInvallida
 * 
 * 
 **/
public class ComentariosTest {
    /*
    @Test
    public void EntradaAlForo(){
       Usuario persona = new Usuario("felipe.losada@gmail.com","Felipe");
       Comentario comentarioAgregado = new Comentario(persona,"Esta muy chebre",new java.sql.Date(2016,9,28));
       try{
           EntradaForo Ef = new EntradaForo(80, persona, comentarioAgregado.getContenido(), "Experiencia", new java.sql.Date(2016,9,28));
           System.out.println(1);
           ServiciosForoStub sft = new ServiciosForoStub();
           System.out.println(2);
           sft.registrarNuevaEntradaForo(Ef);
           EntradaForo x = sft.consultarEntradaForo(1);
           assertEquals("Consulta comentario agregado correctamente",x.getIdentificador(),Ef.getIdentificador());
       }catch(ExcepcionServiciosForos ex){
           fail("No consulta foros agregado");
       }
    }
    
    @Test
    public void RegistroDeEntradaForos(){
        Usuario persona = new Usuario("felipe.losada@gmail.com","Felipe");
        Comentario comentarioAgregado = new Comentario(persona,"Esta muy chebre",new java.sql.Date(2016,9,28));
        try{
            ServiciosForoStub sft = new ServiciosForoStub();
            EntradaForo Ef = new EntradaForo(80, persona, comentarioAgregado.getContenido(), "Experiencia", new java.sql.Date(2016,9,28));
            sft.registrarNuevaEntradaForo(Ef);
            EntradaForo f1 = new EntradaForo(80, persona, comentarioAgregado.getContenido(), "java", new java.sql.Date(2016,9,28));
            EntradaForo f2 = new EntradaForo(80, persona, comentarioAgregado.getContenido(), "c++", new java.sql.Date(2016,9,20));
            EntradaForo f3 = new EntradaForo(80, persona, comentarioAgregado.getContenido(), "python", new java.sql.Date(2016,9,18));
            EntradaForo f4 = new EntradaForo(80, persona, comentarioAgregado.getContenido(), "assembler", new java.sql.Date(2016,7,28));
            EntradaForo f5 = new EntradaForo(80, persona, comentarioAgregado.getContenido(), "c#", new java.sql.Date(2016,5,2));
            EntradaForo f6 = new EntradaForo(80, persona, comentarioAgregado.getContenido(), ".net", new java.sql.Date(2014,9,28));
            sft.registrarNuevaEntradaForo(f1);
            sft.registrarNuevaEntradaForo(f2);
            sft.registrarNuevaEntradaForo(f3);
            sft.registrarNuevaEntradaForo(f4);
            sft.registrarNuevaEntradaForo(f5);
            sft.registrarNuevaEntradaForo(f6);            
            List<EntradaForo> revisar = sft.consultarEntradasForo();
            int i = 2;
            for(EntradaForo x: revisar){
                assertEquals(x.getIdentificador(),i);
                i++;
            }
        }catch(ExcepcionServiciosForos ex){
            fail("No consulta foros agregado en gran cantidad");
        }
    }*/
    
}

