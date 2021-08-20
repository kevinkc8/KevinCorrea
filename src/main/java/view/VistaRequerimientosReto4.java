package view;

import controller.ControladorRequerimientosReto4;
import model.vo.LiderCiudad;
import model.vo.SumaProveedor;
import model.vo.ProyectoCiudad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;



public class VistaRequerimientosReto4 extends JFrame {

    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    
    private JPanel contentPane;
    private static JTextArea textArea;

    public VistaRequerimientosReto4(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbltitulo = new JLabel("Reto 5");
        lbltitulo.setBounds(28,6,61,16);
        contentPane.add(lbltitulo);

        JLabel lblautor = new JLabel("Kevin Stiven Correa Rodriguez");
        lblautor.setBounds(28,34,208,16);
        contentPane.add(lblautor);

        JScrollPane scrolPane = new JScrollPane();
        scrolPane.setBounds(28,70,737,455);
        contentPane.add(scrolPane);

        textArea = new JTextArea();
        scrolPane.setViewportView(textArea);

        JButton btnConsulta1 = new JButton("Consulta 1");
        btnConsulta1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento1();
            }
        });
        btnConsulta1.setBounds(28,537,117,29);
        contentPane.add(btnConsulta1);

        JButton btnConsulta2 = new JButton("Consulta 2");
        btnConsulta2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento3();
            }
        });
        btnConsulta2.setBounds(157,537,117,29);
        contentPane.add(btnConsulta2);

        JButton btnConsulta3 = new JButton("Consulta 3");
        btnConsulta3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento4();
            }
        });
        btnConsulta3.setBounds(286,537,117,29);
        contentPane.add(btnConsulta3);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        btnLimpiar.setBounds(648,537,117,29);
        contentPane.add(btnLimpiar);


    }

    public static void requerimiento1() {

        

        try {

            ArrayList<ProyectoCiudad> rankingProyectoCiudad = controlador.consultarProyectoCiudad();

            // Encabezado del resultado
            String salida = "--- Proyecto Ciudad --- \n\nConstructora\t\tFechaInicio\t\t\tClasificacion\n\n";

            // Cada VO cargado, mostrarlo en la vista
            for (ProyectoCiudad proyectoCiudad : rankingProyectoCiudad) {
                
                salida += proyectoCiudad.getConstructora();
                salida += "\t\t";
                salida += proyectoCiudad.getFechaInicio();
                salida += "\t";
                salida += proyectoCiudad.getClasificacion();
                salida += "\n";
            }
            textArea.setText(salida);

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

    public static void requerimiento3() {

        

        try {

            ArrayList<SumaProveedor> rankingSumaProveedor = controlador.consultarSumaProveedor();

            // Encabezado del resultado
            String salida1 ="-----Suma Cantidades----\n";

            // Cada VO cargado, mostrarlo en la vista
            for (SumaProveedor suma : rankingSumaProveedor) {
                salida1 += "\n";
                salida1 +=  suma.getCantidad();

            }
            textArea.setText(salida1);
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

    public static void requerimiento4() {

       

        try {

            ArrayList<LiderCiudad> rankingLiderCiudad = controlador.consultarLiderCiudad();

            // Encabezado del resultado
            String salida2 ="---Nombre Líder--- \n";

            // Cada VO cargado, mostrarlo en la vista
            for (LiderCiudad lider : rankingLiderCiudad) {
                salida2 += "\n";
                salida2 +=  lider.getNombreLider();
            }
            textArea.setText(salida2);
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

}
