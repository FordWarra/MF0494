/**
 * 
 */
package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.InfractorDAO;
import dao.SancionDAO;
import modelo.Infractor;
import modelo.Sancion;
import vista.DialogoInsertarInfractor;
import vista.VentanaMostrarInfractores;
import vista.VentanaPpal;

/**
 * @author David
 *
 */
public class Controlador {

	// VEntanas del sistema
	private VentanaPpal ventanaPpal;
	private DialogoInsertarInfractor dialogoInsertarInfractor;
	private VentanaMostrarInfractores ventanaMostrarInfractores;

	
	// Objetos DAO o CRUD de la base de datos
	private SancionDAO sancionDAO;
	private InfractorDAO infractorDAO;

	
	public Controlador() {
		// Creamos las ventanas de la aplicación
		ventanaPpal = new VentanaPpal();
		dialogoInsertarInfractor = new DialogoInsertarInfractor();
		ventanaMostrarInfractores = new VentanaMostrarInfractores();
		
		
		// Dando acceso al controlador desde las vistas
		ventanaPpal.setControlador(this);
		dialogoInsertarInfractor.setControlador(this);
		ventanaMostrarInfractores.setControlador(this);
		
		
		// Creamos los objetos DAO
		sancionDAO = new SancionDAO();
		infractorDAO = new InfractorDAO();
	}
	
	public void inciarPrograma() {
		ventanaPpal.setVisible(true);
	}

	public void mostrarInsertarInfractores () {
		ArrayList<Sancion> listaSanciones = new ArrayList<Sancion>();
		listaSanciones = sancionDAO.obtenerSanciones();
		dialogoInsertarInfractor.setListaSanciones(listaSanciones);
		dialogoInsertarInfractor.setVisible(true);
	}
	
	public void mostrarListarInfractores() {
		ArrayList<Infractor> lista = infractorDAO.obtenerInfractor();
		ventanaMostrarInfractores.setListaInfracctores(lista);
		ventanaMostrarInfractores.setVisible(true);
	}
	
	public void insertaInfractor(Infractor infractor) {
		
		int resultado = infractorDAO.insertarInfractor(infractor);
		if (resultado == 0) {
			JOptionPane.showMessageDialog(dialogoInsertarInfractor, "Error. no se ha podido insertar.");
		} else {
			JOptionPane.showMessageDialog(dialogoInsertarInfractor, "Inserción del infractor correcta");
			dialogoInsertarInfractor.setVisible(false);
		}
	}
	
}
