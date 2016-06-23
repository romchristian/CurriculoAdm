/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import py.com.palermo.curriculoadm.entities.Area;
import py.com.palermo.curriculoadm.entities.Ciudad;
import py.com.palermo.curriculoadm.entities.Curriculo;
import py.com.palermo.curriculoadm.entities.Departamento;
import py.com.palermo.curriculoadm.entities.Empresa;
import py.com.palermo.curriculoadm.entities.EstadoCivil;
import py.com.palermo.curriculoadm.entities.EstadoCurriculo;
import py.com.palermo.curriculoadm.entities.EstadoNivelAcademico;
import py.com.palermo.curriculoadm.entities.Estudio;
import py.com.palermo.curriculoadm.entities.Experiencia;
import py.com.palermo.curriculoadm.entities.Localidad;
import py.com.palermo.curriculoadm.entities.Nacionalidad;
import py.com.palermo.curriculoadm.entities.NivelAcademico;
import py.com.palermo.curriculoadm.entities.TipoDocumento;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.ICiudadDAO;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.ICurriculoDAO;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.IEmpresaDAO;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.IEstudioDAO;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.IExperienciaDAO;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.ILocalidadDAO;

/**
 *
 * @author christian.romero
 */
@Named
@SessionScoped
public class CurriculoFilter implements Serializable {

    @EJB
    private ICurriculoDAO dao;

    @EJB
    private ICiudadDAO ciudadDAO;

    @EJB
    private ILocalidadDAO localidadDAO;
    @EJB
    private IExperienciaDAO experienciaDAO;
    @EJB
    private IEstudioDAO estudioDAO;
    @EJB
    private IEmpresaDAO empresaDAO;

    //actual seleccionado
    private Curriculo actual;

    //Filtros
    private Integer rangoEdad1 = 18;
    private Integer rangoEdad2 = 50;

    private NivelAcademico nivelAcademico;
    private EstadoNivelAcademico estadoNivelAcademico;
    private EstadoCivil estadoCivil;

    private Nacionalidad nacionalidad;
    private String sexo;
    private Empresa empresa;
    private Area area;
    private Estudio estudio;
    private Experiencia experiencia;
    private Departamento departamento;
    private Ciudad ciudad;
    private Localidad localidad;
    private TipoDocumento tipoDocumento;

    private String tieneHijos;
    private String nombre;
    private EstadoCurriculo estadoCurriculo;

    //Param
    private int estado;

    //Resultado
    private List<Curriculo> resultado;

    //Getter y Setter
    public EstadoCurriculo getEstadoCurriculo() {
        return estadoCurriculo;
    }

    public void setEstadoCurriculo(EstadoCurriculo estadoCurriculo) {
        this.estadoCurriculo = estadoCurriculo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Curriculo getActual() {
        return actual;
    }

    public void setActual(Curriculo actual) {
        this.actual = actual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getRangoEdad1() {
        return rangoEdad1;
    }

    public void setRangoEdad1(Integer rangoEdad1) {
        this.rangoEdad1 = rangoEdad1;
    }

    public Integer getRangoEdad2() {
        return rangoEdad2;
    }

    public void setRangoEdad2(Integer rangoEdad2) {
        this.rangoEdad2 = rangoEdad2;
    }

    public NivelAcademico getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(NivelAcademico nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public EstadoNivelAcademico getEstadoNivelAcademico() {
        return estadoNivelAcademico;
    }

    public void setEstadoNivelAcademico(EstadoNivelAcademico estadoNivelAcademico) {
        this.estadoNivelAcademico = estadoNivelAcademico;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTieneHijos() {
        return tieneHijos;
    }

    public void setTieneHijos(String tieneHijos) {
        this.tieneHijos = tieneHijos;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<Curriculo> getResultado() {
        return resultado;
    }

    public void setResultado(List<Curriculo> resultado) {
        this.resultado = resultado;
    }

    public ICurriculoDAO getDao() {
        return dao;
    }

    public void setDao(ICurriculoDAO dao) {
        this.dao = dao;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public Experiencia getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Experiencia experiencia) {
        this.experiencia = experiencia;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public String cargaEstado() {
        System.out.println("Estado Curriculo: " + estadoCurriculo);
        if (estado > 0) {
            switch (estado) {
                case 1:
                    estadoCurriculo = EstadoCurriculo.NUEVO;
                    break;
                case 2:
                    estadoCurriculo = EstadoCurriculo.PRESELECCIONADO;
                    break;
                case 3:
                    estadoCurriculo = EstadoCurriculo.CONTRATADO;
                    break;
            }

            busca();

        }

        return null;
    }

    private String filtroNombre() {
        String R = "";
        if (nombre != null && nombre.length() > 0) {
            R = " AND upper(nombres) like '%" + nombre.toUpperCase() + "%' ";
        }

        return R;
    }

    //Métodos para el filtro
    private String filtroEdad() {
        String R = "";
        if (rangoEdad1 != null && rangoEdad2 != null) {
            R = " AND date_part('year',age(fechanacimiento)) between " + rangoEdad1 + " and " + rangoEdad2 + " ";
        }

        return R;
    }

    private String filtroEstadoCivil() {
        String R = "";
        if (estadoCivil != null) {
            R = " AND estadocivil_id = " + estadoCivil.getId() + " ";
        }

        return R;
    }

    private String filtroEmpresa() {
        String R = "";
        if (empresa != null) {
            R = " AND empresa_id = " + empresa.getId() + " ";
        }

        return R;
    }

    private String filtroArea() {
        String R = "";
        if (area != null) {
            R = " AND area_id = " + area.getId() + " ";
        }

        return R;
    }

    private String filtroEstudio() {
        String R = "";
        if (estudio != null) {
            R = " AND estudio_id = " + estudio.getId() + " ";
        }

        return R;
    }

    private String filtroExperiencia() {
        String R = "";
        if (experiencia != null) {
            R = " AND experiencia_id = " + experiencia.getId() + " ";
        }

        return R;
    }

    private String filtroDepartamento() {
        String R = "";
        if (departamento != null) {
            R = " AND departamento_id = " + departamento.getId() + " ";
        }

        return R;
    }

    private String filtroCiudad() {
        String R = "";
        if (ciudad != null) {
            R = " AND ciudad_id = " + ciudad.getId() + " ";
        }

        return R;
    }

    private String filtroLocalidad() {
        String R = "";
        if (localidad != null) {
            R = " AND localidad_id = " + localidad.getId() + " ";
        }

        return R;
    }

    private String filtroNivelAcademico() {
        String R = "";
        if (nivelAcademico != null) {
            R = " AND nivelacademico_id = " + nivelAcademico.getId() + " ";
        }

        return R;
    }

    private String filtroEstadoNivelAcademico() {
        String R = "";
        if (estadoNivelAcademico != null) {
            R = " AND estadonivelacademico_id = " + estadoNivelAcademico.getId() + " ";
        }

        return R;
    }

    private String filtroNacionalidad() {
        String R = "";
        if (nacionalidad != null) {
            R = " AND nacionalidad_id = " + nacionalidad.getId() + " ";
        }

        return R;
    }

    private String filtroSexo() {
        String R = "";
        if (sexo != null && sexo.length() > 0) {
            R = " AND sexo = '" + sexo + "' ";
        }

        return R;
    }

    private String filtroEstadoCurriculo() {
        String R = "";
        if (estadoCurriculo != null) {
            R = " AND (estadocurriculo = '" + estadoCurriculo.toString() + "' OR estadocurriculo is null)";
        }

        return R;
    }

    private String filtroTieneHijos() {
        String R = "";
        if (tieneHijos != null) {
            switch (tieneHijos) {
                case "CON HIJOS":
                    R = " AND cantidadHijos > 0 ";
                    break;
                case "SIN HIJOS":
                    R = " AND (cantidadHijos = 0  OR cantidadHijos is null) ";
                    break;
            }
        }
        return R;
    }

    private String construyeFiltro() {
        StringBuilder sb = new StringBuilder(" WHERE 1 = 1 ");
        sb.append(filtroNombre());
        sb.append(filtroEdad());
        sb.append(filtroArea());
        sb.append(filtroEmpresa());
        sb.append(filtroEstadoCivil());
        sb.append(filtroNivelAcademico());
        sb.append(filtroEstadoNivelAcademico());
        sb.append(filtroNacionalidad());
        sb.append(filtroTieneHijos());
        sb.append(filtroSexo());
        sb.append(filtroEstadoCurriculo());
        sb.append(filtroDepartamento());
        sb.append(filtroCiudad());
        sb.append(filtroLocalidad());
        sb.append(filtroEstudio());
        sb.append(filtroExperiencia());

        return sb.toString();
    }

    public void busca() {
        resultado = dao.findAllFilter(construyeFiltro());
    }

    public SelectItem[] getSelectItemsCiudades() {

        List<Ciudad> listaCiudades;
        if (getActual() != null && getActual().getDepartamento() != null) {
            listaCiudades = ciudadDAO.findAllActivePorDepartamento(getActual().getDepartamento());
        } else {
            listaCiudades = new ArrayList<>();
        }

        SelectItem[] items = new SelectItem[listaCiudades.size() + 1];
        int i = 0;
        items[0] = new SelectItem("", "Ninguna");
        i++;
        for (Ciudad c : listaCiudades) {
            items[i++] = new SelectItem(c, c.toString());
        }

        return items;
    }

    public SelectItem[] getSelectItemsLocalidades() {

        List<Localidad> listaLocalidades;
        if (getActual() != null && getActual().getDepartamento() != null) {
            listaLocalidades = localidadDAO.findAllActivePorDepartamento(getActual().getDepartamento());
        } else {
            listaLocalidades = new ArrayList<>();
        }

        SelectItem[] items = new SelectItem[listaLocalidades.size() + 1];
        int i = 0;
        items[0] = new SelectItem("", "Ninguna");
        i++;
        for (Localidad l : listaLocalidades) {
            items[i++] = new SelectItem(l, l.toString());
        }

        return items;
    }

    public SelectItem[] getSelectItemsExperiencias() {

        List<Experiencia> listaExperiencias;
        if (empresa == null) {
            listaExperiencias = experienciaDAO.findAllSinEmpresa();

        } else if (empresaDAO.tieneExperiencia(empresa)) {
            listaExperiencias = experienciaDAO.findAllConEmpresa(empresa);
        } else {
            listaExperiencias = experienciaDAO.findAllSinEmpresa();
        }

        SelectItem[] items = new SelectItem[listaExperiencias.size() + 1];
        int i = 0;
        items[0] = new SelectItem("", "Ninguna");
        i++;
        for (Experiencia e : listaExperiencias) {
            items[i++] = new SelectItem(e, e.toString());
        }

        return items;
    }

    public SelectItem[] getSelectItemsEstudios() {

        List<Estudio> listaEstudios;
        if (empresa == null) {
            listaEstudios = estudioDAO.findAllSinEmpresa();

        } else if (empresaDAO.tieneEstudio(empresa)) {
            listaEstudios = estudioDAO.findAllConEmpresa(empresa);
        } else {
            listaEstudios = estudioDAO.findAllSinEmpresa();
        }

        SelectItem[] items = new SelectItem[listaEstudios.size() + 1];
        int i = 0;
        items[0] = new SelectItem("", "Niguno");
        i++;
        for (Estudio e : listaEstudios) {
            items[i++] = new SelectItem(e, e.toString());
        }

        return items;
    }

}
