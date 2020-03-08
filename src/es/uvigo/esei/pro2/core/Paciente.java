/*
 * Definicion de la clase Paciente
 */

package es.uvigo.esei.pro2.core;

/**
 *
 * @author nrufino
 * Modified by ASJDevs
 */

public class Paciente {
    private String numHistorial; // Código de la historia médica 
    private String nombre;  // Nombre completo del paciente
    private String domicilio;  
    private int ano;    // Año de nacimiento del paciente
    private TipoPaciente tipo;

    /*
    private boolean privado;
    private boolean asegurado;
     */

    public static enum TipoPaciente {
        PRIVADO,
        ASEGURADO
    }

    /** Crea un nuevo paciente, con sus datos: numero historial, nombre, 
     *  domicilio y año
     * @param numHistorial número del historial médico
     * @param nombre nombre completo del paciente
     * @param domicilio  el domicilio del paciente
     * @param ano el ano de nacimiento del paciente
     */
    public Paciente(String numHistorial, String nombre, String domicilio, int ano) {
        /*
        setEtiquetaPrivado(false);
        setEtiquetaAsegurado(false);
         */

        tipo = TipoPaciente.PRIVADO;
        this.setNumHistorial(numHistorial);
        this.setNombre(nombre);
        this.setDomicilio(domicilio);
        this.setAno(ano);
    }

    /** Devuelve el tipo de paciente
     * @return el tipo del paciente, como TipoPaciente.
     */
    public TipoPaciente getTipo() {
        return tipo;
    }

    /** Cambia el tipo de paciente
     * @param tipo el nuevo tipo de paciente, como TipoPaciente.
     */
    public void setTipo(TipoPaciente tipo) {
        this.tipo = tipo;
    }

    /** Devuelve el número del historial médico del paciente
     * @return el numHistorial de paciente, como String
     */
    public String getNumHistorial() {
        return numHistorial;
    }

    /** Cambia el  número del historial médico del paciente
     * @param nH el nuevo numHistorial de paciente, como String
     */
    public void setNumHistorial(String nH) {
        numHistorial = nH;
    }

    /** Devuelve el nombre del paciente
     *  @return El nombre, como cadena
     **/
    public String getNombre() {
        return nombre;
    }

    /** Cambia el nombre del paciente
     * @param nombre El nuevo nombre, como cadena
     */
    public void setNombre(String nombre) {
        this.nombre = nombre.trim();
    }
    
    /** Devuelve el domicilio del paciente
     *  @return El domicilio, como cadena
     **/
    public String getDomicilio() {
        return domicilio;
    }

    /** Cambia el domicilio del paciente
     * @param domicilio El nuevo domicilio, como cadena
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio.trim();
    }

    /** Devuelve el año de nacimiento del paciente
     *  @return el año de nacimiento del paciente, como entero
     **/
    public int getAno() {
        return ano;
    }

    /** Cambia el año de nacimiento del paciente
     * @param ano el nuevo año de nacimiento del paciente, como entero
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

//    /** Devuelve el valor de la etiqueta privado
//     * @return true si se encuentra activa, false en otro caso
//     */
//    public boolean estaEtiquetadoComoPrivado() {
//        return privado;
//    }
//
//    /** Cambia la etiqueta privado
//     * @param privado El nuevo valor, como boolean
//     */
//    public void setEtiquetaPrivado(boolean privado) {
//        this.privado = privado;
//    }
//
//    /** Devuelve el valor de la etiqueta asegurado
//     * @return true si se encuentra activa, false en otro caso
//     */
//    public boolean estaEtiquetadoComoAsegurado() {
//        return asegurado;
//    }
//
//    /** Cambia la etiqueta asegurado
//     * @param asegurado El nuevo valor, como boolean
//     */
//    public void setEtiquetaAsegurado(boolean asegurado) {
//        this.asegurado = asegurado;
//    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(getNumHistorial()).append(" ; ")
                .append(getNombre()).append(" ; ")
                .append(getDomicilio()).append(" ; ")
                .append(getAno()).append(" ; ");

        if (getTipo() == Paciente.TipoPaciente.PRIVADO) {
            sb.append("privado ");
        } 
        else {
            sb.append("asegurado ");
        }

        return sb.toString();
    }
}

