package org.example

/* ESEMPIO di utilizzo di GET() e SET() per una proprietà */
/* Classe per rappresentare esclusivamente numeri INTERI e POSITIVI */
class Numero() {
    /* Parola chiave 'field': riferimento alla proprietà di cui si sta scrivendo il GET() e/o il SET();
     * -> In questo caso 'field': 'valore: Int' 
     */
    var valore: Int = 0
        get()
        {
            return field
        }
        set(value)
        {
            require(value>=0)
            field = value
        }

    /* Equivalente al SET() - implementato tramite funzione */
    fun inserisciValore(value: Int)
    {
        require(value>=0)
        valore = value
    }
}

fun main()
{
    val uInteger: Numero = Numero()

    /* CHIAMATA del metodo SET() */
    /* set(value)       value = 12 */
    uInteger.valore = 12

    /* CHIAMATA del metodo GET() */
    /* get() */
    println(uInteger.valore)
}
