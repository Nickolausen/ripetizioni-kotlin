import org.example.recupero_estivo.Bolletta
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.*

class BollettaTest {

    @Test
    fun bolletta_DatiCorretti()
    {
        assertDoesNotThrow {
            val bol: Bolletta = Bolletta(2.4)
        }
    }

    @Test
    fun bolletta_DatiErrati()
    {
        assertThrows<IllegalStateException> {
            val bol: Bolletta = Bolletta(-2.4)
        }
    }

    @Test
    fun calcolaImporto() {
        val bolletta: Bolletta = Bolletta(450.0)
        val expected: Double = 1670.0

        assertEquals(expected, bolletta.calcolaImporto())
    }
}