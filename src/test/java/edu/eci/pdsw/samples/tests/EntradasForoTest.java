/*
 * Copyright (C) 2015 hcadavid
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
import java.util.*;
import edu.eci.pdsw.samples.services.ExcepcionServiciosForos;
import edu.eci.pdsw.samples.services.ServiciosForoStub;
import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 * 
 * 
 * clases de equivalencia
 * 
 * clase1:si el comentario no tiene asociado un usuario
 * falla:si
 * nombre:registrarNuevaEntradaForoDebeFallar
 * 
 * clase2:si el comentario tiene asociado un usuario
 * falla:no
 * nombre:registrarNuevaEntradaForoDebeFuncionar
 */
public class EntradasForoTest {
    public EntradasForoTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void registrarNuevaEntradaForoDebeFuncionar() throws ExcepcionServiciosForos{
        Usuario usuario = new Usuario("johan.ramirez@gmail.com","Johan");
        Comentario comentario = new Comentario(usuario,"Esta muy feo",new java.sql.Date(2016,9,28));
        EntradaForo entrada = new EntradaForo(1, usuario, comentario.getContenido(), "Experiencia", new java.sql.Date(2016,9,28));
        entrada.agregarComentario(comentario);
       
    }
  
    
    @Test
    public void registrarNuevaEntradaForoDebeFallar() throws ExcepcionServiciosForos{
        Usuario usuario = new Usuario("johan.ramirez@gmail.com","Johan");
        Comentario comentario = new Comentario(usuario,"no esta Esta muy feo",new java.sql.Date(2016,9,28));
        EntradaForo entrada = new EntradaForo(1, usuario, comentario.getContenido(), "Experiencia", new java.sql.Date(2016,9,28));
        entrada.agregarComentario(comentario);
        assertEquals("Consulta comentario agregado correctamente",comentario.getContenido(), "no esta Esta muy feo");
       
    }
    
    
}
