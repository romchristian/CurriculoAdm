/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.converters;

import javax.faces.convert.FacesConverter;
import py.com.palermo.curriculoadm.entities.NivelAcademico;
import py.com.palermo.curriculoadm.generico.ConverterGenerico;

/**
 *
 * @author christian
 */
@FacesConverter(forClass = NivelAcademico.class)
public class NivelAcademicoConverter extends ConverterGenerico<NivelAcademico> {

    @Override
    public String getBeanName() {
        return "nivelAcademicoBean";
    }
}
