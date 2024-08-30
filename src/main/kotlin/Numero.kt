package org.example

class Numero() {
    /* Classe per rappresentare esclusivamente numeri INTERI e POSITIVI */
    var valore: Int = 0
        get()
        {
            return field
        }
        set(value)
        {
            require(value>=0)
            field = value * 2
        }

    fun inserisciValore(value: Int)
    {
        require(value>=0)
        valore = value
    }
}

fun main()
{
    val numero = Numero()

    /* CHIAMATA del metodo SET() */
    /* set(value)       value = 12 */
    numero.valore = 12

    /* CHIAMATA del metodo GET() */
    /* get() */
    println(numero.valore)
}