/*
*   ESERCIZIO 7: Giada è un grande appassionata di giochi di ruolo ed ogni settimana gioca una partita di cui
    memorizza il punteggio finale.
    Il punteggio finale di una partita è sempre un numero maggiore o uguale al punteggio ottenuto
    nella partita precedente (non è possibile perdere punti tra una partita e la successiva ma solo
    aggiungerne quindi per esempio se nella partita 1 ho fatto 10 punti, non potrò avere un punteggio
    inferiore a 10 nelle successive)
    In un anno ci sono 52 settimane.
    Scrivi una classe Gioco che permetta a Giada di memorizzare i risultati delle partite di un anno.
    In particolare deve essere possibile:
    ● memorizzare il risultato ottenuto in una certa partita giocata in una certa settimana
    ● contare quante volte si è realizzato il punteggio pari a zero (ovvero il punteggio era
    uguale a quello della settimana precedente). (tenere conto che se una settimana non si è
    giocato il valore sarà null e devo considerare l’ultimo valore utile presente nell’array
    ● restituire il risultato ottenuto in una certa settimana (restituire null se non si è registrato
    nessun risultato per la settimana)
    ● calcolare quante partite ha impiegato per raggiungere 100 punti
* */

package org.example.recupero_estivo

class Gioco()
{
    private val punteggioSettimane: Array<Int?> = arrayOfNulls(52)

    /* ● memorizzare il risultato ottenuto in una certa partita giocata in una certa settimana */
    fun inserisciPunteggio(score: Int, settimana: Int)
    {
        /* Controllo la validità del numero della settimana */
        check(settimana in punteggioSettimane.indices)

        /* Individuo l'ultimo punteggio memorizzato prima del punteggio che sto per inserire */
        var lastScore: Int = -1
        for (i in settimana downTo 0) {
            if (punteggioSettimane[i] != null) {
                lastScore = punteggioSettimane[i]!!
                break
            }
        }

        /* Controllo che il punteggio che voglio inserire sia maggiore o uguale dell'ultimo memorizzato */
        check(score >= lastScore)
        punteggioSettimane[settimana] = score
    }

    /* ● contare quante volte si è realizzato il punteggio pari a zero (ovvero il punteggio era
    uguale a quello della settimana precedente). (tenere conto che se una settimana non si è
    giocato il valore sarà null e devo considerare l’ultimo valore utile presente nell’array */
    fun contaZero(): Int
    {
        var output: Int = 0
        for (score in punteggioSettimane)
            if (score!! == 0) output++
            else break

        return output
    }

    /* ● restituire il risultato ottenuto in una certa settimana (restituire null se non si è registrato
    nessun risultato per la settimana) */
    fun getRisultatoSettimana(settimana: Int): Int?
    {
        check(settimana in punteggioSettimane.indices)
        return punteggioSettimane[settimana]
    }

    /* ● calcolare quante partite ha impiegato per raggiungere 100 punti */
    fun contaPartite(): Int
    {
        var output: Int = 0
        var somma: Int = 0
        var i: Int = 0

        while (i < punteggioSettimane.size && somma <= 100)
        {
            somma += punteggioSettimane[i]!!
            output++

            i++
        }

        return output
    }
}

fun main()
{
    val gioco = Gioco()
    gioco.inserisciPunteggio(5, 5)
    gioco.inserisciPunteggio(4, 3)
    gioco.inserisciPunteggio(1, 2)
}