/*
* ESERCIZIO 5: Scrivere una classe Studente che permette di memorizzare nome, cognome e voti in pagella
* dello studente.
* la classe deve avere inoltre una fun per calcolare il numero di insufficienze; una fun per calcolare
* l’esito finale (promosso, non ammesso, sospeso)
* Ricorda: senza insufficienze si è promossi a giugno, con meno di 4 insufficienze e la totalità dei
* punti mancanti alla sufficienza è inferiore o uguale a 5 si è sospesi, altrimenti si è non ammessi
* */

package org.example.recupero_estivo

class Studente(
    _nome: String,
    _cognome: String,
    _voti: Array<Int>)
{
    val nome: String
    val cognome: String
    val voti: Array<Int>

    /* Aggiuntivo: proprietà 'media' */
    var media: Double = 0.0
        get() {
            var sum: Int = 0
            for (voto in voti)
                sum += voto
            return (sum / voti.size).toDouble()
        }
        private set

    init {
        require(_nome != "") { "Un nome non può essere vuoto!" }
        require(_cognome != "") { "Un cognome non può essere vuoto!" }

        for (voto in _voti)
            require(voto in 1..10) {"Un voto deve essere compreso tra 1 e 10!"}

        this.nome = _nome
        this.cognome = _cognome
        this.voti = _voti
    }

    fun calcolaNumeroInsufficienze(): Int
    {
        var totale: Int = 0
        for (voto in voti)
            if (voto < 6) totale++

        return totale
    }

    fun esitoFinale(): String
    {
        /* Calcolo il numero di insufficienze in pagella */
        val nrInsufficienze: Int = calcolaNumeroInsufficienze()

        /* Se ce ne sono almeno 4, allora lo studente non è ammesso all'anno successivo */
        if (nrInsufficienze >= 4) return "Non ammesso"

        /* In questo punto del codice possiamo avere un numero di insufficienze compreso tra 0 e 3 */
        /* Calcoliamo i punti mancanti al 6 per ogni insufficienza */
        var puntiMancanti: Int = 0
        for (voto in voti)
            if (voto < 6) puntiMancanti += (6 - voto)

        /* Se il conteggio dei punti rientra nel range 1..5, allora lo studente è Sospeso */
        if (puntiMancanti in 1..5) return "Sospeso"

        /* Altrimenti lo studente aveva 0 insufficienze e, di conseguenza, 0 punti mancanti alla sufficienza */
        return "Promosso"
    }

    /* Aggiuntiva */
    fun printStatus()
    {
        println("== Studente ${this.nome} ${this.cognome} ==")
        println("> Media ${this.media} - Esito: ${this.esitoFinale()}")
        print("> Voti finali: ")
        for (voto in this.voti)
            print("${voto} ")
        println()
    }
}

fun main()
{
    val s1 = Studente("Nicholas", "Magi", arrayOf(8,9,3,1,10,5))
    val s2 = Studente("Alex", "Burioli", arrayOf(10,5,7,2,8,10,4,4,2,9))

    s1.printStatus()
    s2.printStatus()
}