
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcModel {

    //... Constantes
    private static final String VALOR_INICIAL = "0";

    //... Variable miembro que define el estado de la calculadora.
    private BigDecimal m_total; // Soporta enteros largos y flotantes de alta precisión.

    //============================================================ constructor
    /** Constructor */
    CalcModel() {
        reset();
    }

    //==================================================================== reset
    /** Restablece al valor inicial. */
    public void reset() {
        m_total = new BigDecimal(VALOR_INICIAL);
    }

    //==================================================================== add
    /** Suma un número al total actual.
     *@param operand Número (como cadena) que se sumará.
     */
    public void add(String operand) {
        m_total = m_total.add(new BigDecimal(operand));
    }

    //================================================================= subtract
    /** Resta un número al total actual.
     *@param operand Número (como cadena) que se restará.
     */
    public void subtract(String operand) {
        m_total = m_total.subtract(new BigDecimal(operand));
    }

    //=============================================================== multiplyBy
    /** Multiplica el total actual por un número (entero o flotante largo).
     *@param operand Número (como cadena) por el cual se multiplicará el total.
     */
    public void multiplyBy(String operand) {
        m_total = m_total.multiply(new BigDecimal(operand));
    }

    //================================================================= divideBy
    /** Divide el total actual entre un número.
     *@param operand Número (como cadena) divisor.
     */
    public void divideBy(String operand) {
        BigDecimal divisor = new BigDecimal(operand);
        // Se define una escala de 10 decimales y redondeo HALF_UP para evitar errores de división infinita
        m_total = m_total.divide(divisor, 10, RoundingMode.HALF_UP);
    }

    //================================================================= setValue
    /** Establece el valor total.
     *@param value Nuevo valor que se usará para el total de la calculadora.
     */
    public void setValue(String value) {
        m_total = new BigDecimal(value);
    }

    //================================================================= getValue
    /** Retorna el total actual de la calculadora. */
    public String getValue() {
        return m_total.toString();
    }
}