/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.converters;

import javax.faces.convert.FacesConverter;
import py.com.palermo.curriculoadm.entities.TipoDocumento;
import py.com.palermo.curriculoadm.generico.ConverterGenerico;

/**
 *
 * @author christian
 */
@FacesConverter(forClass = TipoDocumento.class)
public class TipoDocumentoConverter extends ConverterGenerico<TipoDocumento> {

    @Override
    public String getBeanName() {
        return "tipoDocumentoBean";
    }
}
