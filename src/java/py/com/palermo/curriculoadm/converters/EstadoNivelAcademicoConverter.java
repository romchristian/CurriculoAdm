/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.converters;

import javax.faces.convert.FacesConverter;
import py.com.palermo.curriculoadm.entities.EstadoNivelAcademico;
import py.com.palermo.curriculoadm.generico.ConverterGenerico;

/**
 *
 * @author christian
 */
@FacesConverter(forClass = EstadoNivelAcademico.class)
public class EstadoNivelAcademicoConverter extends ConverterGenerico<EstadoNivelAcademico> {

    @Override
    public String getBeanName() {
        return "estadoNivelAcademicoBean";
    }
}
