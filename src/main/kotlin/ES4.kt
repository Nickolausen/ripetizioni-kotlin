/*  ESERCIZIO 4: Scrivere una classe bolletta che, dato il consumo di acqua di un utente (espresso in metri cubi),
*   possiede una fun per il calcolo dell'importo della bolletta, sapendo che ogni bolletta comprende
*   una quota fissa di 20 euro e una quota
*   variabile di 2,50 euro/m3 per i primi 100 metri cubi d'acqua, di euro 4,00/m3 per i metri cubi in
*   eccesso.
*/

package org.example

class Bolletta(_consumoUtente: Double)
{
    val consumoUtente: Double
    val quotaFissa: Double = 20.0

    init {
        check(_consumoUtente > 0.0)

        this.consumoUtente = _consumoUtente
    }

    fun calcolaImporto(): Double
    {
        var importoTotale: Double = quotaFissa
        /* Se sottrarre 100 al totale del consumo utente mi restituisce una quantità maggiore di 0,
        allora ho superato i 100 metri cubi */
        if (consumoUtente - 100 > 0)
            importoTotale += (consumoUtente - 100) * 4.00 + 100 * 2.50
        else
            importoTotale += consumoUtente * 2.50

        return importoTotale
    }
}

fun main()
{
    val b1 = Bolletta(450.0)
    println("Bolletta #1, consumo: ${b1.consumoUtente} m^3; Importo totale: €${b1.calcolaImporto()}")
}