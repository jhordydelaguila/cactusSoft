package cactussoft.capa1_presentacion.util;

import cactussoft.capa3_dominio.entidades.Mesa;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Formateador {

    public static final Color COLOR_ENTRADA_VALIDO = new Color(255, 255, 255);
    public static final Color COLOR_ENTRADA_OBLIGATORIO = new Color(230, 255, 255);
    public static final Color COLOR_ENTRADA_INVALIDO = new Color(250, 220, 220);
    public static final Color COLOR_ENTRADA_UNICO = new Color(255, 100, 0);

    public static final Color COLOR_MESA_LIBRE = new Color(0, 255, 0);
    public static final Color COLOR_MESA_OCUPADO = new Color(255, 0, 0);

    public static void limpiarCampoDeTexto(ArrayList<JTextField> listaDeCampoDeTexto) {
        for (JTextField campoDeTexto : listaDeCampoDeTexto) {
            campoDeTexto.setText("");
        }
    }

    public static void limpiarCampoDeArea(ArrayList<JTextArea> listaDeCampoDeArea) {
        for (JTextArea campoDeArea : listaDeCampoDeArea) {
            campoDeArea.setText("");
        }
    }

    public static void limpiarPanelDeTexto(ArrayList<JTextPane> listaDePanelDeTexto) {
        for (JTextPane panelDeTexto : listaDePanelDeTexto) {
            panelDeTexto.setText("");
        }
    }

    public static void limpiarCampoDeSpinner(ArrayList<JSpinner> listaDeCampoDeSpinner) {
        for (JSpinner campoDeSpinner : listaDeCampoDeSpinner) {
            campoDeSpinner.setValue(0);
        }
    }

    public static void limpiarCampoDeFecha(ArrayList<JDateChooser> listaDeCamposDeFecha) {
        for (JDateChooser campoDeFecha : listaDeCamposDeFecha) {
            campoDeFecha.setDate(null);
        }
    }

    public static void pintarBotonDisponibilidadLibre(ArrayList<JButton> listaDeBotones, String disponibilidad) {
        for (JButton boton : listaDeBotones) {
            if (Mesa.DISPONIBILIDAD_LIBRE.equals(disponibilidad)) {
                boton.setBackground(COLOR_MESA_LIBRE);
            } else if (Mesa.DISPONIBILIDAD_OCUPADO.equals(disponibilidad)) {
                boton.setBackground(COLOR_MESA_OCUPADO);
            }
        }
    }

    public static void pintarBotonDisponibilidadOcupado(ArrayList<JButton> listaDeBotones, String disponibilidad) {
        for (JButton boton : listaDeBotones) {
            if (Mesa.DISPONIBILIDAD_OCUPADO.equals(disponibilidad)) {
                boton.setBackground(COLOR_MESA_OCUPADO);
            }
        }
    }

    public static void insertarImagenEnBoton(ArrayList<JButton> listaDeBotones, ImageIcon imagen) {
        for (JButton boton : listaDeBotones) {
            boton.setIcon(imagen);
        }
    }

    public static void extenderVentanaFrameCompleta(JFrame frame) {
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
    }

    public static void centrarVentanaDialog(JDialog dialog) {
        dialog.setLocationRelativeTo(dialog);
    }

    public static void centrarVentanaFrame(JFrame frame) {
        frame.setLocationRelativeTo(frame);
    }

    public static void pintarComponentesDeEntradaObligatoria(ArrayList<JComponent> listaDeDatosDeEntrada, ArrayList<String> datosObligatorios) {
        for (JComponent componente : listaDeDatosDeEntrada) {
            if (datosObligatorios.contains(componente.getName())) {
                componente.setBackground(COLOR_ENTRADA_OBLIGATORIO);
            }
        }
    }

    public static void pintarEtiquetasDeValorUnico(ArrayList<JLabel> listaDeEtiquetas, ArrayList<String> datosUnicos) {
        for (JLabel etiquetas : listaDeEtiquetas) {
            if (datosUnicos.contains(etiquetas.getName())) {
                etiquetas.setForeground(COLOR_ENTRADA_UNICO);
            }
        }
    }

    public static void pintarCajaDeTextoValido(JTextField cajaDeTexto) {
        cajaDeTexto.setBackground(COLOR_ENTRADA_VALIDO);
    }

    public static void pintarCajaDeTextoInvalido(JTextField cajaDeTexto) {
        cajaDeTexto.setBackground(COLOR_ENTRADA_INVALIDO);
    }

    public static void pintarCajaDeTextoObligatorio(JTextField cajaDeTexto) {
        cajaDeTexto.setBackground(COLOR_ENTRADA_OBLIGATORIO);
    }
}
