package entidades;

import java.util.ArrayList;

/**
 *
 * @author Juan Javier Arosemena
 */
public class Infante {
    public static final int MAX_CEDULA_LENGTH = 10;
    private String nombre;
    private ArrayList<Integer> cedula;
    private int edad;

    public Infante() {
        nombre = "";
        cedula = new ArrayList<>(MAX_CEDULA_LENGTH);
        edad = 0;
    }

    public Infante(String nom, ArrayList<Integer> ced, int eda) {
        nombre = nom;
        if(ced.size() <= MAX_CEDULA_LENGTH)
            cedula = ced;
        edad = eda;
    }
    
    public Infante(String nom, String ced, int eda) {
        nombre = nom;
        cedula = new ArrayList<>();
        String cedule = "";
        for(int i=ced.length()-1 ; i>=0 ; i--){
            if(Character.toString(ced.charAt(i)).matches("[0-9]"))
                cedule = ced.charAt(i) + cedule;
            else
                cedule = "0" + cedule;
        }
        for(int i=0 ; i<(MAX_CEDULA_LENGTH-ced.length()) ; i++){
            cedule = "0" + cedule;
        }
        for (int i=0 ; i<cedule.length() ; i++) {
            cedula.add(Integer.parseInt(Character.toString(cedule.charAt(i))));
        }
        
        edad = eda;
    }

    public void setNombre(String nom) {
        nombre = nom;
    }

    public boolean setCedula(ArrayList<Integer> ced) {              //Cambiado en UML
        if(ced.size() <= MAX_CEDULA_LENGTH){
            cedula = ced;
            return true;
        }
        return false;
    }
    
    public boolean setCedula(String ced) {                             //No esta en UML
        if(ced.matches("//d+") && ced.length()<=MAX_CEDULA_LENGTH){
            cedula.clear();
            cedula.ensureCapacity(MAX_CEDULA_LENGTH);
            for(int i=1 ; i<=ced.length() ; i++)
                cedula.set(-i, Integer.parseInt(Character.toString(ced.charAt(-i))));
            return true;
        }
        return false;
    }

    public void setEdad(int eda) {
        edad = eda;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Integer> getCedula() {
        return cedula;
    }
    
    public String getCedulaString() {
        String ced = "";
        for(Integer dig: cedula)
            ced += Integer.toString(dig);
        return ced;
    }

    public int getEdad() {
        return edad;
    }
}
