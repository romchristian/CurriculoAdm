/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ejb.EJB;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;

import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import py.com.palermo.curriculoadm.entities.Curriculo;
import py.com.palermo.curriculoadm.entities.ReferenciaLaboral;
import py.com.palermo.curriculoadm.entities.ReferenciaPersonal;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.BeanGenerico;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.ICurriculoDAO;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class CurriculoBean extends BeanGenerico<Curriculo> implements Serializable {

    @EJB
    private ICurriculoDAO ejb;
    private String diaNac;
    private String mesNac;
    private String anioNac;
    private UploadedFile file;

    @Override
    public Curriculo getActual() {
        Curriculo R = super.getActual();
        if(R.getId() == null || R.getId() == 0){
            
            
            List<ReferenciaLaboral> refsLaboral = new ArrayList<>();
            refsLaboral.add(new ReferenciaLaboral());
            refsLaboral.add(new ReferenciaLaboral());
            
            getActual().setReferenciasLaborales(refsLaboral);
            
            
            List<ReferenciaPersonal> refsPersonales = new ArrayList<>();
            refsPersonales.add(new ReferenciaPersonal());
            refsPersonales.add(new ReferenciaPersonal());
            
            getActual().setReferenciasPersonales(refsPersonales);
        }
        
        return R;
    }
    
    
    

    @Override
    public AbstractDAO<Curriculo> getEjb() {
        return ejb;
    }

    @Override
    public Curriculo getNuevo() {
        return new Curriculo();
    }

    public String getDiaNac() {
        return diaNac;
    }

    public void setDiaNac(String diaNac) {
        this.diaNac = diaNac;
    }

    public String getMesNac() {
        return mesNac;
    }

    public void setMesNac(String mesNac) {
        this.mesNac = mesNac;
    }

    public String getAnioNac() {
        return anioNac;
    }

    public void setAnioNac(String anioNac) {
        this.anioNac = anioNac;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public SelectItem[] getSelectItemsDias() {
        SelectItem[] items = new SelectItem[32];
        items[0] = new SelectItem("", "--");
        for (int i = 1; i < 32; i++) {
            items[i] = new SelectItem("" + i, "" + i);
        }
        return items;
    }

    public SelectItem[] getSelectItemsAnios() {
        SelectItem[] items = new SelectItem[41];
        items[0] = new SelectItem("", "--");
        for (int i = 1; i < 41; i++) {
            items[i] = new SelectItem("" + (i + 1959), "" + (i + 1959));
        }
        return items;
    }

    public SelectItem[] getSelectItemsMes() {
        SelectItem[] items = new SelectItem[13];
        items[0] = new SelectItem("", "--");
        items[1] = new SelectItem("Enero", "Enero");
        items[2] = new SelectItem("Febrero", "Febrero");
        items[3] = new SelectItem("Marzo", "Marzo");
        items[4] = new SelectItem("Abril", "Abril");
        items[5] = new SelectItem("Mayo", "Mayo");
        items[6] = new SelectItem("Junio", "Junio");
        items[7] = new SelectItem("Julio", "Julio");
        items[8] = new SelectItem("Agosto", "Agosto");
        items[9] = new SelectItem("Septiembre", "Septiembre");
        items[10] = new SelectItem("Octubre", "Octubre");
        items[11] = new SelectItem("Noviembre", "Noviembre");
        items[12] = new SelectItem("Diciembre", "Diciembre");

        return items;
    }

    public void handleFileUpload(FileUploadEvent event) throws IOException {
        if (event.getFile() != null) {

            file = event.getFile();
            getActual().setAdjunto(file.getFileName());
            System.out.println("FILE: " + file);
        }
    }

    public void copyFile() {
        try {

            System.out.println("FILE en COPY: " + file);
            FacesContext fc = FacesContext.getCurrentInstance();
            String destination = fc.getExternalContext().getInitParameter("uploadDirectory");
           
            final String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            destination += uuid;
            
            OutputStream out = new FileOutputStream(new File(destination + file.getFileName() + "." + (file.getFileName().split("\\."))[1]));

            System.out.println("DIR:  " + destination);
            int read = 0;
            byte[] bytes = new byte[1024];

            InputStream in = file.getInputstream();
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();

            
            System.out.println("New file created!");
            
            
            getActual().setDirectoryUUID(uuid);
            
        } catch (IOException e) {
            getActual().setAdjunto(null);
            System.out.println(e.getMessage());
        }
    }

    public void guardar() {
        copyFile();
        edit();
    }
}
