
import java.awt.event.*;

public class CalcController {

    private CalcModel m_model;
    private CalcView m_view;

    //========================================================== constructor
    CalcController(CalcModel model, CalcView view) {
        m_model = model;
        m_view = view;

        //... Agregar escuchas (listeners) a todos los botones de la vista.
        m_view.addAddListener(new AddListener());
        m_view.addSubtractListener(new SubtractListener());
        m_view.addMultiplyListener(new MultiplyListener());
        m_view.addDivideListener(new DivideListener());
        m_view.addClearListener(new ClearListener());
    }

    ////////////////////////////////////////// clase interna AddListener (Suma)
    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
                userInput = m_view.getUserInput();
                m_model.add(userInput);
                m_view.setTotal(m_model.getValue());
            } catch (NumberFormatException nfex) {
                m_view.showError("Entrada no válida: '" + userInput + "'");
            }
        }
    }

    ////////////////////////////////////////// clase interna SubtractListener (Resta)
    class SubtractListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
                userInput = m_view.getUserInput();
                m_model.subtract(userInput);
                m_view.setTotal(m_model.getValue());
            } catch (NumberFormatException nfex) {
                m_view.showError("Entrada no válida: '" + userInput + "'");
            }
        }
    }

    ////////////////////////////////////////// clase interna MultiplyListener (Multiplicación)
    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
                userInput = m_view.getUserInput();
                m_model.multiplyBy(userInput);
                m_view.setTotal(m_model.getValue());
            } catch (NumberFormatException nfex) {
                m_view.showError("Entrada no válida: '" + userInput + "'");
            }
        }
    }

    ////////////////////////////////////////// clase interna DivideListener (División)
    class DivideListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
                userInput = m_view.getUserInput();
                m_model.divideBy(userInput);
                m_view.setTotal(m_model.getValue());
            } catch (ArithmeticException | NumberFormatException ex) {
                m_view.showError("Error en división (¿división entre cero o entrada inválida?): '" + userInput + "'");
            }
        }
    }

    //////////////////////////////////////////// clase interna ClearListener (Limpiar)
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_model.reset();
            m_view.reset();
        }
    }
}