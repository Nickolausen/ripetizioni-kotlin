package org.example

// TESTO ESERCIZI (no OOP): https://docs.google.com/document/d/1mEwATKgGadPUb8JpO1svB_Zab4s2xV7KnnPc9e0nPvc/edit?usp=sharing
// TODO: realizzare Test per ogni funzione
// N.B.: Non tutti gli esercizi sono stati realizzati - alcuni sono dei doppioni di esercizi già svolti in precedenza
class Soluzioni()
{
    /* Scrivere un algoritmo che, date le età di n persone, calcoli l’età media. */
    fun Esercizio1(eta: Array<Int>): Double {
        return eta.average()
    }

    /* Scrivere un algoritmo che, dato il prezzo di un prodotto, calcoli il prezzo scontato del 20%. */
    fun Esercizio2(prezzo: Double): Double {
        /* sconto del 20% */
        return prezzo * 0.8
    }

    /* Scrivere un algoritmo che, lette le coordinate di due punti del piano, calcoli la distanza tra essi. */
    fun Esercizio3(x1: Double, y1: Double, x2: Double, y2: Double): Double {
        val dx: Double = x1 - x2
        val dy: Double = y1 - y2

        return Math.sqrt(dx * dx + dy * dy)
    }

    /* Scrivere un algoritmo che, dato il prezzo di un prodotto, applichi uno sconto del 12% se il prezzo è inferiore a € 30,00, del 25% altrimenti. */
    fun Esercizio4(prezzo: Double): Double {
        require(prezzo > 0.0)

        /* Sconto del 12% */
        if (prezzo < 30) return prezzo * 0.88

        /* Sconto del 25% */
        return prezzo * 0.75
    }

    /* Il biglietto di ingresso ad un museo ha le seguenti tariffe.
    Per i bambini di età inferiore a 6 anni l'ingresso è gratuito (opzione 1),
    per gli studenti 8 euro (opzione 2), per i pensionati 10 euro (opzione 3),
    per tutti gli altri 15 euro (opzione 4).
    Creare un programma in cui l’utente inserisce un numero tra 1 e 4 e viene comunicato il prezzo relativo all'opzione scelta.
    Se il numero non è un'opzione valida viene mostrato un messaggio di errore.*/
    fun Esercizio7(opzione: Int): Int {
        require(opzione in 1..4) { "Opzione must be between 1 and 4" }

        return when (opzione)
        {
            1 -> 0
            2 -> 8
            3 -> 10
            4 -> 15
            else -> -1
        }
    }

    /* Scrivere un algoritmo che visualizza in ordine decrescente tutti i numeri naturali compresi tra due numeri scelti dall'utente (estremi inclusi). */
    fun Esercizio8(lowerBound: Int, upperBound: Int): String {
        require(lowerBound < upperBound) { "Upper bound must be greater than lower bound" }

        val sb: StringBuilder = StringBuilder()

        for (num: Int in upperBound-1 downTo lowerBound+1)
        {
            sb.append("$num ")
        }

        return sb.toString().trimEnd()
    }

    /* Scrivere un algoritmo che, preso in input il valore N>0, calcoli la somma dei primi N numeri positivi pari. */
    fun Esercizio9(N: Int): Int {
        require(N > 0) { "N must be greater than 0" }

        var sum: Int = 0
        for (num: Int in 0..N)
            sum += if (num % 2 == 0) num else 0

        return sum
    }

    /* Scrivere un algoritmo che, presi in input due numeri interi N ed X (con N>0), visualizzi gli N numeri interi successivi ad X.  */
    fun Esercizio10(N: Int, X: Int): String {
        require(N > 0) { "N must be greater than 0" }

        val sb: StringBuilder = StringBuilder()
        for (num: Int in X..X + N)
            sb.append("$num ")

        return sb.toString().trimEnd()
    }

    /* Dati quantità e prezzo unitario di N tipologie di prodotti venduti, calcolare l’incasso totale e il numero totale di prodotti prelevati dal magazzino. */
    fun Esercizio12(prezzi: Array<Double>, qtas: Array<Int>): String {
        require(prezzi.size == qtas.size) {"Inconsistent number of values!"}

        for (prezzo in prezzi)
            require(prezzo > 0.0) { "Prezzo must be positive - not $prezzo" }

        for (qta in qtas)
            require(qta > 0) { "Qta must be positive - not $qta" }

        var incassoTot: Double = 0.0

        for (i: Int in 0 until qtas.size) {
            incassoTot += prezzi[i] * qtas[i]
        }

        return "€$incassoTot ${qtas.sum()}"
    }
}
