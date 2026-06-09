package ni.edu.uam.pruebasunitarias
import org.junit.Assert.assertEquals
import org.junit.Test

class CalculadoraTest {

    private val calculadora = Calculadora()

    @Test
    fun verificarSuma() {
        assertEquals(8, calculadora.sumar(5, 3))
    }

    @Test
    fun verificarResta() {
        assertEquals(2, calculadora.restar(5, 3))
    }

    @Test
    fun verificarMultiplicacion() {
        assertEquals(15, calculadora.multiplicar(5, 3))
    }

    @Test
    fun verificarDivision() {
        assertEquals(2.5, calculadora.dividir(5, 2), 0.0)
    }

    @Test
    fun verificarSumaConNegativos() {
        assertEquals(-2, calculadora.sumar(-5, 3))
        assertEquals(-8, calculadora.sumar(-5, -3))
    }

    @Test
    fun pruebaQueFallaIntencionalmente() {
        // Se espera 10, pero 5+3 es 8. Esto fallará a propósito.
        assertEquals(10, calculadora.sumar(5, 3))
    }
}
