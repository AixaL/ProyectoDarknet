package proyectodarknet;
import Errores.ErrorArchivo;
import Errores.ErrorEscritura;
import archivos.Archivo;
import procesamiento.enumeradores.Columna;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import procesamiento.enumeradores.Operador;
import procesamiento.enumeradores.Tipo;
import procesamiento.extractor.Extractor;
import procesamiento.filtro.Filtro;
import procesamiento.manager.Manager;
import static constantes.ConstantesDeEjecucion.*;

 
public class Formulario extends JFrame implements ActionListener {
 
    // Components of the Form
    private Container c;
    private JLabel titulo;
    private JLabel rutaText;
    private JLabel label;
    private JTextField ruta;
    private JLabel gender;
    private JLabel colText;
    private JComboBox colInteres;
    private JComboBox cri;
    private JComboBox op;
    private JLabel add;
    private JLabel criT;
    private JTextField criText;
    private JTextField tadd;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JTextPane tout;
    private JLabel res;
    private JTextArea resadd;
    private JButton addC;
    
    private String operadores[] = { "=", ">", "<"};
    
//    private String numeradores[] = {'a','b','c','d','e'};
 
 
    ArrayList<String> columnasName = new ArrayList<>();
    ArrayList<Columna> columnas = new ArrayList<>();
    ArrayList<String> columnasId = new ArrayList<>();
    ArrayList<String> columnasSel = new ArrayList<>();
    // constructor, to initialize the components
    // with default values.
    public Formulario()
    {
        for (Columna columna: Columna.values()) {
                System.out.println(columna);
                columnasName.add(columna.getNombre());
                columnas.add(columna);
//                columnasId.add(columna.getPosicion());
        }
        System.out.println(columnas);
        
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        c = getContentPane();
        c.setLayout(null);
 
        titulo = new JLabel("Registration Form");
        titulo.setFont(new Font("Arial", Font.PLAIN, 30));
        titulo.setSize(300, 30);
        titulo.setLocation(300, 30);
        c.add(titulo);
 
        rutaText = new JLabel("Ingresa la ruta de tu archivo");
        rutaText.setFont(new Font("Arial", Font.PLAIN, 20));
        rutaText.setSize(350, 20);
        rutaText.setLocation(100, 100);
        c.add(rutaText);
 
        ruta = new JTextField();
        ruta.setFont(new Font("Arial", Font.PLAIN, 15));
        ruta.setSize(350, 40);
        ruta.setLocation(100, 130);
        c.add(ruta);
 
        colText = new JLabel("Columnas de interes");
        colText.setFont(new Font("Arial", Font.PLAIN, 20));
        colText.setSize(200, 20);
        colText.setLocation(100, 200);
        c.add(colText);
 
        String[] array = columnasName.toArray(new String[columnasName.size()]);
        
        colInteres = new JComboBox(array);
        colInteres.setFont(new Font("Arial", Font.PLAIN, 15));
        colInteres.setSize(250, 40);
        colInteres.setLocation(100, 230);
        c.add(colInteres);
        
        addC = new JButton("Agregar");
        addC.setFont(new Font("Arial", Font.PLAIN, 15));
        addC.setSize(100, 40);
        addC.setLocation(350, 230);
        addC.addActionListener(this);
        c.add(addC);
        
        label = new JLabel("Columnas:");
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        label.setSize(400, 80);
        label.setLocation(100, 250);
        c.add(label);
       
 
        criT = new JLabel("Criterio de busqueda");
        criT.setFont(new Font("Arial", Font.PLAIN, 16));
        criT.setSize(400, 20);
        criT.setLocation(100, 330);
        c.add(criT);
        
        cri = new JComboBox(array);
        cri.setFont(new Font("Arial", Font.PLAIN, 15));
        cri.setSize(180, 40);
        cri.setLocation(100, 370);
        c.add(cri);
        
        op = new JComboBox(operadores);
        op.setFont(new Font("Arial", Font.PLAIN, 15));
        op.setSize(50, 40);
        op.setLocation(280, 370);
        c.add(op);
 
        criText = new JTextField();
        criText.setFont(new Font("Arial", Font.PLAIN, 15));
        criText.setSize(130, 40);
        criText.setLocation(330, 370);
        c.add(criText);
 
        term = new JCheckBox("Filtros de tiempo");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 420);
        c.add(term);
 
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 470);
        sub.addActionListener(this);
        c.add(sub);
 
        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 470);
        reset.addActionListener(this);
        c.add(reset);
 
        tout = new JTextPane();
        tout.setContentType("text/html");
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
//        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);
 
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 520);
        c.add(res);
 
        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);
 
        setVisible(true);
    }
 
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == addC) {
                String data2 =  (String)colInteres.getSelectedItem();

                
                System.out.println(label.getText());
                
                String texto = label.getText().replaceAll("</html>", "");
                texto = texto.replaceAll("<html>", "");

                
                texto = texto + " / " + data2;
                
                columnasSel.add(data2);
                
//                String data3 = "Address : " + tadd.getText();
                
                label.setText(label.getText() +" "+ data2);
                final String html = "<html>"+ texto +"</html>";
                label.setText(html);
//                tout.setText(data + data1 + data2 + data3);
//                tout.setEditable(false);
//                res.setText("Registration Successfully..");
//            }
//            else {
//                tout.setText("");
//                resadd.setText("");
//                res.setText("Please accept the"
//                            + " terms & conditions..");
//            }
        }
        
        else if(e.getSource() == sub){

            Set<Columna> columnasRequeridas1 =  new HashSet<Columna>();
            int posicion1 = 0;
            Tipo tipo1 = Tipo.DOUBLE;
//            tout.append( "Columnas de interes \n");
            String list = "";
             for (int i=0;i<columnasSel.size();i++) {
                    System.out.println(columnasSel.get(i));
                     for (int j=0;j<columnas.size();j++) {
                        if(columnas.get(j).getNombre() == columnasSel.get(i) ){
                            System.out.println(columnas.get(j).getTipo());
                            columnasRequeridas1.add(columnas.get(j));
                        }
                        
                    }
                    list = list + "<li>" + columnasSel.get(i) + "</li>";
                  }
//            tout.append( "Ruta del archivo \n");
            
            System.out.print(columnasRequeridas1);
//          tout.append( "Criterio de filtrado \n");
            String criterioB = (String)cri.getSelectedItem()+ " " +(String) op.getSelectedItem()+ " " + criText.getText();
            
            tout.setText("<h2>Datos finales </h2>"
                    + "<h4>Columnas:</h4>"
                    + "<ul>"+list+ "</ul>"
                    + "<h4>Criterio de busqueda</h4>"
                    + "<p>"+criterioB+"</p>"
                    + "<h4>Ruta del archivo: </h4>"
                    + "<p>"+ruta.getText()+"</p>");

            // for (int i=0;i<columnasSel.size();i++) {
            //     System.out.println(columnasSel.get(i));
            //     list = list + "<li>" + columnasSel.get(i) + "</li>";
            // }


           
            for (int j=0;j<columnas.size();j++) {
                if(columnas.get(j).getNombre() == cri.getSelectedItem() ){
                    posicion1 = columnas.get(j).getPosicion();
                    tipo1 = columnas.get(j).getTipo();
                }
                
            }


            // int         posicion1   = posicion1.getPosicion();
            Operador    operador1   = Operador.MORETHAN;
            String      valor1      = "40000"; // Valor aceptado
            
            Filtro[] filtros1 = {
                new Filtro(
                    posicion1,
                    operador1,
                    valor1,
                    tipo1
                )
            };



            if (!ruta.getText().isBlank()) {
                setRutaArchivoEntrada(ruta.getText());
                System.out.println("Nueva ruta: " + getRutaArchivoEntrada());
            }

            try {
                Archivo.procesarArchivo(getRutaArchivoEntrada());
            } catch (ErrorArchivo ex) {
                Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
            }


            
           
            try {
                new Manager( filtros1 , columnasRequeridas1 );
            } catch (ErrorEscritura ex) {
               System.out.println(ex);
            } catch (InterruptedException ex) {
                System.out.println(ex);
                // Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ErrorArchivo ex) {
                System.out.println(ex);
                // Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
            String rutan =  ruta.getText();
            
            Archivo read = new Archivo();
        }
 
        else if (e.getSource() == reset) {
            String def = "";
            ruta.setText(def);
            criText.setText(def);
//            cri.setText(def);
            label.setText("Columnas: ");
            tout.setText(def);
            term.setSelected(false);
            cri.setSelectedIndex(0);
            colInteres.setSelectedIndex(0);
            op.setSelectedIndex(0);
            resadd.setText(def);
        }
    }
}