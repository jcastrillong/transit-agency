package Excepciones;

public class ExcepcionObjetoExistente extends Exception{

    public ExcepcionObjetoExistente() {
    }

    /**
     * Constructs an instance of <code>ExcepcionObjetoExistente</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionObjetoExistente(String msg) {
        super(msg);
    }
}
