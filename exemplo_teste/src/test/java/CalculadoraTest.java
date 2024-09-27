import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.ryan.Calculadora;

public class CalculadoraTest {
    Calculadora calculadora = new Calculadora();

    @Test
    public void testSoma() {
        int resultado = calculadora.soma(2, 3);
        assertEquals(5, resultado);
    }

    @Test
    public void testSubtrai() {
        int resultado = calculadora.subtrai(5, 2);
        assertEquals(3, resultado);
    }

    @Test
    public void testMultiplica() {
        int resultado = calculadora.multiplica(4, 2);
        assertEquals(8, resultado);
    }

    @Test
    public void testDivide() {
        int resultado = calculadora.divide(10, 2);
        assertEquals(5, resultado);
    }

    @Test
    public void testDividePorZero() {
        // Verifica se a exceção é lançada ao dividir por zero
        assertThrows(IllegalArgumentException.class, () -> calculadora.divide(10, 0));
    }

}
