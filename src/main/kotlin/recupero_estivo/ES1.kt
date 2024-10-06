/*
* ESERCIZIO 1: Scrivere una classe Persona che permetta di memorizzare nome, cognome, data di nascita ed
* abbia una proprietà che ne restituisca l’età calcolata a partire dalla data di nascita.
* Aggiungere alla classe una fun confronto che, preso come parametro un oggetto persona
* restituisca 0 se la persona passa come parametro ha la stessa età, -1 se la persona passata
* come parametro risulta più adulta, 1 se risulta più giovane.
* */

package org.example.recupero_estivo

class Persona(
    val nome: String,
    val cognome: String,
    val dd: Int, /* Giorno di nascita */
    val mm: Int, /* Mese di nascita */
    val yyyy: Int) /* Anno di nascita */
{
    val eta: Int
        get() {
            return calcolaEta()
        }

    private fun calcolaEta(): Int
    {
        var output: Int

        /* Ottengo la data odierna */
        val oggiDd: Int = 23
        val oggiMm: Int = 7
        val oggiYyyy: Int = 2024

        /* Di default, calcolo l'età dando per scontato che il compleanno sia già passato */
        output = oggiYyyy - yyyy
        /* Se ciò non è successo, allora decremento l'età di 1 - perché la persona deve ancora compiere gli anni */
        if (mm > oggiMm || (mm == oggiMm && oggiDd < dd))
            output -= 1

        return output
    }

    fun confronto(p2: Persona): Int
    {
        /* Diamo per scontato che le due persone abbiano la stessa età -
        sarà compito di controlli successivi cambiare il valore di output, se necessario */
        var output: Int = 0

        /* Se la persona passata come parametro è più adulta della persona su cui sto lavorando, allora imposto output a -1 */
        if (p2.eta > this.eta) output = -1
        else if (p2.eta < this.eta) output = 1 /* Altrimenti, se la persona è più giovane, imposto output a 1 */

        return output
    }
}

/* Funzione ausiliaria - non richiesta dalla consegna */
fun getConfronto(result: Int): String
{
    var output: String = "coetaneo"
    if (result == 1)
        output = "più adulto"
    else if (result == -1)
        output = "più giovane"

    return output
}

fun main()
{
    /* -- PRENDIAMO IN CONSIDERAZIONE LA DATA '23/07/2024' COME DATA ODIERNA -- */
    /* Persona che ha già compiuto gli anni nell'anno corrente (2024) */
    val p1 = Persona("Nicholas", "Magi", 1,6,2004)

    /* Persona che deve ancora compiere gli anni nell'anno corrente (2024) */
    val p2 = Persona("Davide", "Rossi", 25,7,2004)

    /* Persona che deve compiere gli anni, ma ha un anno in meno rispetto alle altre */
    val p3 = Persona("Simone", "Mazzacano", 10,9,2005)

    println("Età: " + p1.eta) /* Expected output: 20 */
    println("Età: " + p2.eta) /* Expected output: 19 */
    println("Età: " + p3.eta) /* Expected output: 18 */

    println(p1.nome + " è " + getConfronto(p1.confronto(p2)) + " di " + p2.nome)
    println(p2.nome + " è " + getConfronto(p2.confronto(p1)) + " di " + p1.nome)
    println(p2.nome + " è " + getConfronto(p2.confronto(p3)) + " di " + p3.nome)
}