/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.converters;

import javax.faces.convert.FacesConverter;
import py.com.palermo.curriculoadm.entities.Usuario;
import py.com.palermo.curriculoadm.generico.ConverterGenerico;

/**
 *
 * @author christian
 */
@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter extends ConverterGenerico<Usuario> {

    @Override
    public String getBeanName() {
        return "usuarioBean";
    }
}
