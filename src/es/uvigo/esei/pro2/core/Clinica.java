/*  Definición de la clase Clinica
 *  En una clínica tendremos una serie de pacientes
 */

package es.uvigo.esei.pro2.core;

import java.util.Arrays;

/**
 *
 * @author nrufino
 * Modified by ASJDevs
 */

public class Clinica {
    private Paciente[] pacientes;
    private int numPacientes;

    /** Nueva Clinica con un num. max. de pacientes
     * @param maxPacientes el num. max. de pacientes, como entero
     */
    public Clinica(int maxPacientes) {
        numPacientes = 0;
        pacientes = new Paciente[ maxPacientes  ];
    }

    /**
     * Devuelve el paciente situado en pos
     * @param pos el lugar del paciente en el vector de pacientes
     * @return el objeto Paciente correspondiente.
     */
    public Paciente get(int pos) {
        if (pos >= getNumPacientes()) {
            System.err.println("get(): sobrepasa la pos: " + (pos + 1) 
                                + " / " + getMaxPacientes());
            System.exit(-1);
        }

        return pacientes[ pos ];
    }

    /** Devuelve el num. de pacientes creados
     * @return el num. de pacientes existentes, como entero
     */
    public int getNumPacientes() {
        return numPacientes;
    }

    /** Devuelve el max. de numPacientes
     * @return el num. de pacientes max,, como entero
     */
    public int getMaxPacientes() {
        return pacientes.length;
    }

    public Paciente mayor() {
        Paciente toret = new Paciente("","","",pacientes[0].getAno());
        for (int i = 0; i < numPacientes; i++) {
            if (pacientes[i].getAno() < toret.getAno()) {
                toret = pacientes[i];
            }
        }

        return toret;
    }

    /** Inserta un nuevo paciente
     * @param p el nuevo objeto Paciente
     */



    public void inserta(Paciente p) {
        final int maxPacientes = getMaxPacientes();

        if (getNumPacientes() >= maxPacientes) {
            System.err.println("inserta(): sobrepasa max.: " + maxPacientes);
            System.exit(-1);
        }

        pacientes[ numPacientes ] = p;
        ++numPacientes;
    }

    public void elimina(int pos) {
        if (getNumPacientes() != 0 && pos >= 0 && pos < getNumPacientes()) {
            for (int i = pos; i < getNumPacientes()-1; i++) {
                pacientes[i] = pacientes [i+1];
            }
            numPacientes--;
        } else {
            System.err.println("Error");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if (getNumPacientes() > 0) {
            sb.append("Clínica:\n");
            for (int i = 0; i < getNumPacientes(); i++) {
                sb.append(i+1)
                        .append(". ")
                        .append(get(i).getNombre())
                        .append(" | ").append(get(i).getNumHistorial())
                        .append(" | ").append(get(i).getAno())
                        .append(" | ").append(get(i).getDomicilio());
                if (get(i).getTipo() == Paciente.TipoPaciente.ASEGURADO) {
                    sb.append(" | Asegurado");
                } else {
                    sb.append(" | Privado");
                }
                sb.append(".\n");
            }
        } else {
            sb.append("No hay pacientes.\n");
        }

        return sb.toString();
    }
}
