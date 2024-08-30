import org.example.Studente
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

/*
* Link utili:
* -- https://kotlinlang.org/docs/api-guidelines-predictability.html#validate-inputs-and-state (Documentazione Kotlin)
* -- https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/check.html (Documentazione Kotlin)
* */

/* Alcuni test per la classe Studente */
class StudenteTest {

    @Test
    fun studente_VotoNegativo() {
        assertThrows<IllegalArgumentException> { Studente("Nicholas", "Magi", arrayOf(1,2,3,-1)) }
    }

    @Test
    fun studente_DatiCorretti() {
        assertDoesNotThrow {
            Studente("Alex", "Burioli", arrayOf(1,2,3,2))
        }
    }

    @Test
    fun calcolaNumeroInsufficienze() {
        val stud = Studente("Nicholas", "Magi", arrayOf(1,2,3))
        val expected = 3
        assertEquals(3, stud.calcolaNumeroInsufficienze())
    }
}