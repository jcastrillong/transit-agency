package Excepciones;

public class ExcepcionObjetoNoEncontrado extends Exception{

    public ExcepcionObjetoNoEncontrado() {
    }

    /**
     * Constructs an instance of <code>ExcepcionObjetoNoEncontrado</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionObjetoNoEncontrado(String msg) {
        super(msg);
    }
}
