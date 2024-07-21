/*
*   ESERCIZIO 6: Vogliamo memorizzare le quantità (peso in grammi) degli ingredienti necessari per una ricetta.
    Gli ingredienti sono n e sono numerati da 0 a n-1.
    Gli ingredienti vengono passati al costruttore di Ricetta.
    La classe deve poter rispondere a queste funzionalità:
    ● restituire il numero di ingredienti necessari per la ricetta
    ● dato il numero di un ingrediente restituire la sua quantità
    ● calcolare il peso totale in grammi degli ingredienti necessari per la ricetta
    ● restituire l'ingrediente con il peso minore
* */

package org.example

class Ingrediente(val nome: String, val peso: Double)

class Ricetta(val nome: String, val ingredienti: Array<Ingrediente>)
{
    /* ● restituire il numero di ingredienti necessari per la ricetta */
    fun calcolaTotale(): Int { return ingredienti.size }

    /* ● dato il numero di un ingrediente restituire la sua quantità */
    fun calcolaQuantita(indiceIngrediente: Int): Double
    {
        check(indiceIngrediente in 0..ingredienti.size - 1) {
            "L'indice dell'ingrediente richiesto deve essere compreso tra 0 e ${ingredienti.size - 1}!"
        }

        return ingredienti[indiceIngrediente].peso
    }

    /* ● calcolare il peso totale in grammi degli ingredienti necessari per la ricetta */
    fun calcolaPesoTotale(): Double
    {
        var totale: Double = 0.0
        for (ingrediente in ingredienti)
            totale += ingrediente.peso

        return totale
    }

    /* ● restituire l'ingrediente con il peso minore */
    fun calcolaPesoMinore(): Ingrediente
    {
        var minimo: Double = Double.MAX_VALUE
        var ingredienteConPesoMinore: Ingrediente = Ingrediente("OUTPUT", 1.0);

        for (ingrediente in ingredienti)
        {
            if (ingrediente.peso < minimo)
            {
                minimo = ingrediente.peso
                ingredienteConPesoMinore = ingrediente
            }
        }

        return ingredienteConPesoMinore
    }
}

fun main()
{
    val ingrediente1: Ingrediente = Ingrediente("Mozzarella", 100.0)
    val ingrediente2: Ingrediente = Ingrediente("Pomodoro", 500.0)
    val ingrediente3: Ingrediente = Ingrediente("Farina", 700.0)
    val ingrediente4: Ingrediente = Ingrediente("Acqua", 250.5)

    val ricetta: Ricetta = Ricetta(
        "Pizza Margherita",
        arrayOf(ingrediente1, ingrediente2, ingrediente3, ingrediente4)
    )

    println("=== RICETTA ${ricetta.nome} ===")
    println("Ingredienti totali: ${ricetta.calcolaTotale()}")
    println("Peso totale: ${ricetta.calcolaPesoTotale()}gr")
    println("Quantità di ${ingrediente2.nome} necessario: ${ricetta.calcolaQuantita(1)}gr")
    println("Ingrediente con peso minore: ${ricetta.calcolaPesoMinore().nome} - ${ricetta.calcolaPesoMinore().peso}gr")
}