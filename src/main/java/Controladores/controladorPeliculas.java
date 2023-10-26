package Controladores;

import App.Conexion;
import javax.swing.JTextField;
import Modelos.modeloPeliculas;
import com.mysql.cj.protocol.Resultset;
import com.sun.java.accessibility.util.SwingEventMonitor;
import static java.lang.Integer.parseInt;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class controladorPeliculas {

    private final modeloPeliculas modelo;

    public controladorPeliculas(modeloPeliculas modelo) {
        this.modelo = modelo;
    }

    public void InsertarPelicula(JTextField paramTitulo, JTextField costoPelicula, JTextField autor, JTextField fechaEstreno, JTextField fechaFin, JTextField genero, JTextField Imagen) throws ParseException {
        modelo.setTituloPelicula(paramTitulo.getText());
        modelo.setCostoEntrada(parseInt(costoPelicula.getText()));
        modelo.setAutor(autor.getText());

        String fechaEstrenoText = fechaEstreno.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaEstrenoDate = dateFormat.parse(fechaEstrenoText);
        modelo.setFechaInicio(fechaEstrenoDate);
        
        String fechaFinText = fechaFin.getText();
        Date fechaFinDate = dateFormat.parse(fechaFinText);
        modelo.setFechaFin(fechaFinDate);
        
        modelo.setGenero(genero.getText());
        
        modelo.setImagen(Imagen.getText());
        
        Conexion objetConexion = new Conexion();
        
        String consulta = ("INSERT INTO Peliculas (tituloPelicula, costoEntrada, autor, genero, fechaInicio, fechaFin, imagen) VALUES  (?,?,?,?,?,?,?)");
        
        try {
            CallableStatement cs = objetConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, modelo.getTituloPelicula());
            cs.setInt(2,modelo.getCostoEntrada());
            cs.setString(3, modelo.getAutor());
            cs.setString(4, modelo.getGenero());
            cs.setDate(5, new java.sql.Date(modelo.getFechaInicio().getTime()));
            cs.setDate(6, new java.sql.Date(modelo.getFechaFin().getTime()));
            cs.setString(7, modelo.getImagen());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se insertó correctamente la pelicula");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un problema: "+e);
        }
    }
    
    public void MostrarPeliculas(JTable paramTabalaPeliculas){
        
        Conexion objectConexion = new Conexion();
        
        DefaultTableModel  modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
        paramTabalaPeliculas.setRowSorter(OrdenarTabla);
        
        String sql = "";
        
        modelo.addColumn("Id");
        modelo.addColumn("Titulo");
        modelo.addColumn("Autor");
        modelo.addColumn("Genero");
        modelo.addColumn("Fecha Estreno");
        modelo.addColumn("Fecha Fin");
        
        paramTabalaPeliculas.setModel(modelo);
        
        sql = "SELECT * FROM peliculas";
        String[] datos = new String[8];
        Statement st;
        
        try {
            st = objectConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(4);
                datos[3]=rs.getString(5);
                datos[4]=rs.getString(6);
                datos[5]=rs.getString(7);
                
                modelo.addRow(datos);
            }
            
            paramTabalaPeliculas.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudieron mostrar los registros "+e);
        }
    }
    
    public void SeleccionarPeliculas(JTable paramTablaPeliculas, JTextField paramId, JTextField paramTitulo, JTextField costoPelicula, JTextField fechaEstreno, JTextField fechaFin, JTextField genero, JTextField Imagen){
        try {
            int fila = paramTablaPeliculas.getSelectedRow();
            
            if(fila >= 0){
                paramId.setText((String) (paramTablaPeliculas.getValueAt(fila, 0)));
                paramTitulo.setText((String) (paramTablaPeliculas.getValueAt(fila, 1)));
                fechaEstreno.setText((String) (paramTablaPeliculas.getValueAt(fila, 4)));
                fechaFin.setText((String) (paramTablaPeliculas.getValueAt(fila, 5)));
            }else{
                JOptionPane.showMessageDialog(null, "FIla no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de seleccion: "+e);
        }
 
    }
}
