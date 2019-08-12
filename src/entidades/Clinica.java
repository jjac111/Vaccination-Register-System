package entidades;

import java.util.ArrayList;

/**
 *
 * @author Juan Javier Arosemena
 */
public class Clinica {

    public static final int MAX_ID_LENGTH = 10;
    public static final int VACUNAS_SIZE = 31;
    private ArrayList<Integer> id;
    private ArrayList<Integer> vacunas;
    private ArrayList<Infante> muestra;

    public Clinica() {
        id = new ArrayList<>(MAX_ID_LENGTH);
        vacunas = new ArrayList<>(VACUNAS_SIZE);
        muestra = new ArrayList<>();
    }

    public Clinica(ArrayList<Integer> iD, ArrayList<Integer> vac, ArrayList<Infante> mue) {
        this();
        if (iD.size() <= MAX_ID_LENGTH) {
            id = iD;
        }
        muestra = mue;
        for (int i = 0; i < Integer.min(VACUNAS_SIZE, vac.size()); i++) {
            vacunas.set(i, vac.get(i));
        }
    }

    public Clinica(String iD, ArrayList<Integer> vac, ArrayList<Infante> mue) { //No esta en UML.
        this();
        if (iD.matches("[0-9]+") && iD.length() <= MAX_ID_LENGTH) {
            id.clear();
            id.ensureCapacity(MAX_ID_LENGTH);
            String ident = "";
            for (int i = iD.length() - 1; i >= 0; i--) {
                if (Character.toString(iD.charAt(i)).matches("[0-9]")) {
                    ident = iD.charAt(i) + ident;
                } else {
                    ident = "0" + ident;
                }
            }
            for (int i = 0; i < (MAX_ID_LENGTH - iD.length()); i++) {
                ident = "0" + ident;
            }
            for (int i = 0; i < ident.length(); i++) {
                id.add(Integer.parseInt(Character.toString(ident.charAt(i))));
            }
        }
        muestra = mue;
        vacunas = new ArrayList<>(VACUNAS_SIZE);
        for (int i = 0; i < Integer.min(VACUNAS_SIZE, vac.size()); i++) {
            vacunas.add(vac.get(i));
        }
    }

    public boolean setId(ArrayList<Integer> iD) {                      //cambiado
        if (iD.size() <= MAX_ID_LENGTH) {
            id = iD;
            return true;
        }
        return false;
    }

    public boolean setId(String iD) {                                          //No esta en UML
        if (iD.matches("//d+") && iD.length() <= MAX_ID_LENGTH) {
            id.clear();
            id.ensureCapacity(MAX_ID_LENGTH);
            for (int i = 1; i <= iD.length(); i++) {
                id.set(-i, Integer.parseInt(Character.toString(iD.charAt(-i))));
            }
            return true;
        }
        return false;
    }

    public void setVacunas(ArrayList<Integer> vac) {
        for (int i = 0; i < Integer.min(VACUNAS_SIZE, vac.size()); i++) {
            vacunas.set(i, vac.get(i));
        }
    }

    public void setMuestra(ArrayList<Infante> mue) {
        muestra = mue;
    }

    public boolean addToMuestra(Infante infante) {
        for (Infante inf : muestra) {
            if (inf.getCedula().equals(infante.getCedula())) {
                return false;
            }
        }
        return muestra.add(infante);
    }

    public void removeFromMuestra(int idx) {
        muestra.remove(idx);
    }

    public ArrayList<Integer> getId() {
        return id;
    }

    public String getIdString() {
        String ID = "";
        for (Integer dig : id) {
            ID += Integer.toString(dig);
        }
        return ID;
    }

    public ArrayList<Integer> getVacunas() {
        return vacunas;
    }

    public Integer getVacunaAt(int dia) {
        return vacunas.get(dia - 1);
    }

    public Integer getVacunasTotal() {
        Integer cant = 0;
        for (Integer elem : vacunas) {
            cant += elem;
        }
        return cant;
    }

    public ArrayList<Infante> getMuestra() {
        return muestra;
    }

    public Infante getMuestraAt(int idx) {
        return muestra.get(idx);
    }

    public Integer getTamanoMuestra() {
        return muestra.size();
    }
}
