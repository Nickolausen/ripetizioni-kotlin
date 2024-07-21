/*
 * ESERCIZIO 3: Scrivere una classe data che memorizza giorno, mese ed anno.
 * Il costruttore deve verificare la correttezza dei parametri ricevuti.
 * Scrivere inoltre una fun che restituisce true se la data è di un anno bisestile, false altrimenti
 * */

package org.example

class Data(
    _giorno: Int,
    _mese: Int,
    _anno: Int)
{
    val giorno: Int
    val mese: Int
    val anno: Int

    init {
        /* Controllo della validità dell'anno */
        check(_anno >= 0) { "'anno' deve essere >= di 0!" }
        this.anno = _anno

        /* Controllo della validità dell'mese */
        check(_mese in 1..12) { "'mese' deve essere compreso tra 1 e 12!" }
        this.mese = _mese

        /*
            Gennaio = upperBounds[0] = 31gg
            Febbraio = upperBounds[1] = 28gg
            Marzo = upperBounds[2] = 31gg
            Aprile = upperBounds[3] = 30gg
            Maggio = upperBounds[4] = 31gg
            Giugno = upperBounds[5] = 30gg
            Luglio = upperBounds[6] = 31gg
            Agosto = upperBounds[7] = 31gg
            Settembre = upperBounds[8] = 30gg
            Ottobre = upperBounds[9] = 31gg
            Novembre = upperBounds[10] = 30gg
            Dicembre = upperBounds[11] = 31gg
         */

        val giorniFebbraio: Int = if (isBisestile()) 29 else 28
        val upperBounds: Array<Int> = arrayOf(
            31,
            giorniFebbraio,
            31,
            30,
            31,
            30,
            31,
            31,
            30,
            31,
            30,
            31)

        val lowerBound: Int = 1
        val upperBound: Int = upperBounds[_mese - 1]
        check(_giorno !in lowerBound..upperBound) { "'giorno' deve essere compreso tra $lowerBound e $upperBound!" }

        this.giorno = _giorno
    }

    /* Criterio: https://learn.microsoft.com/en-us/office/troubleshoot/excel/determine-a-leap-year */
    fun isBisestile(): Boolean {
        if (anno % 4 != 0) return false
        if (anno % 100 != 0) return true
        if (anno % 400 != 0) return false

        return true
    }
}

fun main()
{
    val d1 = Data(12, 6, 1992)
    val d2 = Data(12, 6, 2000)
    val d3 = Data(12, 6, 1900)

    println("L'anno ${d1.anno} ${if (d1.isBisestile()) "è" else "non è"} bisestile")
    println("L'anno ${d2.anno} ${if (d2.isBisestile()) "è" else "non è"} bisestile")
    println("L'anno ${d3.anno} ${if (d3.isBisestile()) "è" else "non è"} bisestile")
}