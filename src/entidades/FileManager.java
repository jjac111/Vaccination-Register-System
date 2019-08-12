/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Javier
 */
public class FileManager {

    private String fileName;
    private DataOutputStream output;
    private DataInputStream input;
    private DataOutputStream infantesOutput;
    private DataInputStream infantesInput;

    public FileManager(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName, true)));
        input = new DataInputStream(new FileInputStream(fileName));
        infantesOutput = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("infantes.data", true)));
        infantesInput = new DataInputStream(new FileInputStream("infantes.data"));
    }

    public FileManager() {
        try {
            infantesOutput = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("infantes.data", true)));
            infantesInput = new DataInputStream(new FileInputStream("infantes.data"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setFileName(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
        input = new DataInputStream(new FileInputStream(fileName));
    }

    public String getFileName() {
        return fileName;
    }

    public void writeSeleccionado(String name, boolean isit) throws IOException {
        output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("infantes_seleccionado.dat", true)));
        output.writeUTF(name);
        if (isit) {
            output.writeUTF("SELECCIONADO");
        } else {
            output.writeUTF("NO SELECCIONADO");
        }
        output.close();
    }

    public void writeEdadPromedio(double prom, ArrayList<Integer> id) throws IOException {
        output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("edades_promedio.dat", true)));
        String writingId = "";
        for (Integer number : id) {
            writingId += Integer.toString(number);
        }
        output.writeUTF(writingId);
        output.writeDouble(prom);
        output.close();
    }

    public void writeMayorVacunacion(ArrayList<Clinica> clis) throws IOException {
        output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("mas_vacunas.dat", true)));
        for (Clinica cli : clis) {
            output.writeUTF(cli.getIdString());
        }
        output.writeUTF("\n");
        output.close();
    }

    public void writeIncumplimiento(ArrayList<Clinica> clis) throws IOException {
        output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("incumplimiento.dat", true)));
        for (Clinica cli : clis) {
            output.writeUTF(cli.getIdString());
        }
        output.writeInt(0);
        output.close();
    }

    public void writeInfantes(ArrayList<Infante> infantes) throws IOException {
        ArrayList<Infante> infantess = infantes;
        infantess.sort((o1, o2) -> {
            return ((Integer) o1.getEdad()).compareTo((Integer) o2.getEdad());
        });
        infantesOutput = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("infantes.data", false)));
        for (Infante inf : infantess) {
            infantesOutput.writeUTF(inf.getCedulaString());
            infantesOutput.writeUTF(inf.getNombre());
            infantesOutput.writeInt(inf.getEdad());
            infantesOutput.flush();
        }
        infantesOutput.close();
    }

    public String readSeleccionado() throws FileNotFoundException {
        String msg = "";
        input = new DataInputStream(new FileInputStream("infantes_seleccionado.dat"));
        try {
            while (true) {
                msg += input.readUTF() + " - ";
                msg += input.readUTF() + "\n";
            }
        } catch (Exception e) {
            msg += "\n\nEnd of File.";
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return msg;
    }

    public String readEdadPromedio() throws FileNotFoundException {
        input = new DataInputStream(new FileInputStream("edades_promedio.dat"));
        String list = "";
        try {
            while (true) {
                list += input.readUTF() + " - ";
                list += input.readDouble() + "\n";
            }
        } catch (Exception e) {
            list += "\n\nEnd of File.";
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public String readMayorVacunacion() throws FileNotFoundException {
        input = new DataInputStream(new FileInputStream("mas_vacunas.dat"));
        String thing;
        String msg = "";
        try {
            msg += input.readUTF();
            while (true) {
                if (!"\n".equals(thing = input.readUTF())) {
                    msg += " - " + thing;
                } else {
                    msg += thing;
                }
            }
        } catch (Exception e) {
            msg += "\n\nEnd of File.";
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return msg;
    }

    public String readIncumplimiento() throws FileNotFoundException {
        input = new DataInputStream(new FileInputStream("incumplimiento.dat"));
        String msg = "";
        try {
            while (true) {
                msg += input.readUTF() + "\n";
            }
        } catch (Exception e) {
            msg += "\n\nEnd of File.";
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return msg;
    }

    public String readInfantes() throws IOException {
        String msg = "";
        infantesInput = new DataInputStream(new FileInputStream("infantes.data"));
        try {
            while (true) {
                msg += infantesInput.readUTF() + " - ";
                msg += infantesInput.readUTF() + " - ";
                msg += infantesInput.readInt() + "\n";
            }
        } catch (Exception e) {
            msg += "\n\nEnd of File.";
            infantesInput.close();
        }
        return msg;
    }

    public ArrayList<Infante> initializeInfantes() {
        ArrayList<Infante> list = new ArrayList<>();
        String nom, ced;
        try {
            infantesInput = new DataInputStream(new FileInputStream("infantes.data"));
            while (true) {
                ced = infantesInput.readUTF();
                nom = infantesInput.readUTF();
                list.add(new Infante(nom, ced, infantesInput.readInt()));
            }

        } catch (Exception ex) {
            try {
                infantesInput.close();
            } catch (IOException ex1) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return list;
    }
}
