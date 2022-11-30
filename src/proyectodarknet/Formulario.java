package proyectodarknet;
import archivos.Archivo;
import procesamiento.enumeradores.Columna;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
 
public class Formulario extends JFrame implements ActionListener {
 
    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JTextField tmno;
    private JLabel gender;
    private JLabel dob;
    private JComboBox date;
    private JLabel add;
    private JTextField tadd;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;
    private JButton addC;
 
 
    ArrayList<String> columnas = new ArrayList<>();
    
    ArrayList<String> columnasSel = new ArrayList<>();
    // constructor, to initialize the components
    // with default values.
    public Formulario()
    {
        for (Columna columna: Columna.values()) {
                System.out.println(columna);
                columnas.add(columna.getNombre());
        }
        System.out.println(columnas);
        
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        c = getContentPane();
        c.setLayout(null);
 
        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);
 
        name = new JLabel("Ingresa la ruta de tu archivo");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(350, 20);
        name.setLocation(100, 100);
        c.add(name);
 
        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(350, 40);
        tname.setLocation(100, 130);
        c.add(tname);
 
        dob = new JLabel("Columnas de interes");
        dob.setFont(new Font("Arial", Font.PLAIN, 20));
        dob.setSize(200, 20);
        dob.setLocation(100, 200);
        c.add(dob);
 
        String[] array = columnas.toArray(new String[columnas.size()]);
        date = new JComboBox(array);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(250, 40);
        date.setLocation(100, 230);
        c.add(date);
        
        addC = new JButton("Agregar");
        addC.setFont(new Font("Arial", Font.PLAIN, 15));
        addC.setSize(100, 40);
        addC.setLocation(350, 230);
        addC.addActionListener(this);
        c.add(addC);
       
 
        add = new JLabel("Criterio de busqueda");
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.setSize(400, 20);
        add.setLocation(100, 300);
        c.add(add);
 
        tadd = new JTextField();
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setSize(350, 50);
        tadd.setLocation(100, 330);
        c.add(tadd);
 
        term = new JCheckBox("Filtros de tiempo");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 400);
        c.add(term);
 
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);
 
        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 450);
        reset.addActionListener(this);
        c.add(reset);
 
        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);
 
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
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
                String data2 =  (String)date.getSelectedItem();
                
                columnasSel.add(data2);
                
                String data3 = "Address : " + tadd.getText();
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
            tout.append( "Columnas de interes \n");
             for (int i=0;i<columnasSel.size();i++) {
                    System.out.println(columnasSel.get(i));
                    tout.append(columnasSel.get(i) + "\n");
                  }
            tout.append( "Ruta del archivo \n");
            
            tout.append( "Criterio de filtrado \n");
            
            String ruta =  tname.getText();
            
            Archivo read = new Archivo(ruta);
        }
 
        else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tadd.setText(def);
            res.setText(def);
            tout.setText(def);
            term.setSelected(false);
            date.setSelectedIndex(0);
            resadd.setText(def);
        }
    }
}