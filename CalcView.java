
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

class CalcView extends JFrame {
    //... Constantes
    private static final String VALOR_INICIAL = "0";

    //... Componentes
    private JTextField m_userInputTf = new JTextField(5);
    private JTextField m_totalTf     = new JTextField(20);
    
    // Botones para las operaciones
    private JButton    m_addBtn      = new JButton("Sumar");
    private JButton    m_subBtn      = new JButton("Restar");
    private JButton    m_multiplyBtn = new JButton("Multiplicar");
    private JButton    m_divideBtn   = new JButton("Dividir");
    private JButton    m_clearBtn    = new JButton("Limpiar");

    private CalcModel m_model;

    //======================================================= constructor
    /** Constructor */
    CalcView(CalcModel model) {
        //... Configurar la lógica
        m_model = model;
        m_model.setValue(VALOR_INICIAL);

        //... Inicializar componentes
        m_totalTf.setText(m_model.getValue());
        m_totalTf.setEditable(false);

        //... Diseñar los componentes
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Entrada"));
        content.add(m_userInputTf);
        
        // Agregar botones de operaciones al panel
        content.add(m_addBtn);
        content.add(m_subBtn);
        content.add(m_multiplyBtn);
        content.add(m_divideBtn);
        
        content.add(new JLabel("Total"));
        content.add(m_totalTf);
        content.add(m_clearBtn);

        //... Finalizar diseño
        this.setContentPane(content);
        this.pack();

        this.setTitle("Calculadora Completa - MVC");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void reset() {
        m_totalTf.setText(VALOR_INICIAL);
    }

    String getUserInput() {
        return m_userInputTf.getText();
    }

    void setTotal(String nuevoTotal) {
        m_totalTf.setText(nuevoTotal);
    }

    void showError(String mensajeError) {
        JOptionPane.showMessageDialog(this, mensajeError);
    }

    // Métodos para registrar las escuchas de cada botón
    void addAddListener(ActionListener aal) {
        m_addBtn.addActionListener(aal);
    }

    void addSubtractListener(ActionListener sal) {
        m_subBtn.addActionListener(sal);
    }

    void addMultiplyListener(ActionListener mal) {
        m_multiplyBtn.addActionListener(mal);
    }

    void addDivideListener(ActionListener dal) {
        m_divideBtn.addActionListener(dal);
    }

    void addClearListener(ActionListener cal) {
        m_clearBtn.addActionListener(cal);
    }
}