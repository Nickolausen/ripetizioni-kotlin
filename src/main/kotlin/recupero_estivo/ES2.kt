/*
* ESERCIZIO 2: Scrivere una classe Prodotto che permette di memorizzare il codice, la descrizione ed il prezzo
* di un prodotto. Definire un fun per il calcolo del prezzo scontato che restituisce il prezzo scontato
* di una certa percentuale passata come parametro
* */

package org.example.recupero_estivo

/* Inseriamo i parametri che caratterizzano le proprietà della classe 'Prodotto' nel costruttore di primo livello */
class Prodotto(
    codice: Int,
    descrizione: String,
    prezzo: Double
) {
    /* Definiamo quindi le effettive proprietà della classe 'Prodotto' */
    val codice: Int
    val descrizione: String
    val prezzo: Double

    /* Definiamo il blocco di codice che inizializza le precedenti proprietà */
    init {
        /* Controlli di validità dei valori passati al costruttore */
        check(descrizione != "")
        check(prezzo >= 0)

        this.codice = codice
        this.descrizione = descrizione
        this.prezzo = prezzo
    }

    /* Assumiamo che il 'percentualeSconto' sia della forma '15%', '50%'... */
    fun calcoloSconto(percentualeSconto: Int): Double
    {
        return this.prezzo * (100 - percentualeSconto) * 0.01
    }
}

fun main()
{
    val p1 = Prodotto(1, "Filetto di Branzino", 5.00)
    val p2 = Prodotto(2, "Pesce Spada", 22.00)
    val p3 = Prodotto(3, "Carpaccio", 9.00)

    println("${p1.descrizione} scontato al 50%! Nuovo prezzo: ${p1.calcoloSconto(50)}€")
    println("${p2.descrizione} scontato al 20%! Nuovo prezzo: ${p2.calcoloSconto(20)}€")
    println("${p3.descrizione} scontato al 30%! Nuovo prezzo: ${p3.calcoloSconto(30)}€")

    /* Errore! Un check contenuto nel blocco 'init' della classe 'Prodotto' fallisce */
    val p4 = Prodotto(3, "", 9.00)
}