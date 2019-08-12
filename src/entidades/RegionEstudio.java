package entidades;

import java.util.ArrayList;

/**
 *
 * @author Juan Javier Arosemena
 */
public class RegionEstudio {

    private ArrayList<Clinica> clinicas;
    private ArrayList<Infante> infantesRegion;

    public RegionEstudio() {
        clinicas = new ArrayList<>();
        infantesRegion = new ArrayList<>();
    }

    public RegionEstudio(ArrayList<Clinica> cli, ArrayList<Infante> inf) {
        clinicas = cli;
        infantesRegion = inf;
    }

    public void setClinicas(ArrayList<Clinica> cli) {
        clinicas = cli;
    }

    public void setClinica(Clinica cli, int idx) {
        clinicas.set(idx, cli);
    }

    public void setInfantesRegion(ArrayList<Infante> infantesRegion) {
        this.infantesRegion = infantesRegion;
    }

    public void setInfanteAt(Infante inf, int idx) {
        infantesRegion.set(idx, inf);
    }

    public void addClinica(Clinica cli) {
        clinicas.add(cli);
    }

    public void addInfante(Infante inf) {
        infantesRegion.add(inf);
    }

    public void addInfanteAtClinica(Infante inf, int idx) {
        clinicas.get(idx).addToMuestra(inf);
    }

    public ArrayList<Clinica> getClinicas() {
        return clinicas;
    }

    public Clinica getClinicaAt(int idx) {
        return clinicas.get(idx);
    }

    public Clinica getClinica(ArrayList<Integer> id) {
        for (Clinica elem : clinicas) {
            if (elem.getId().equals(id)) {
                return elem;
            }
        }
        return null;
    }

    public ArrayList<Infante> getInfantesRegion() {
        return infantesRegion;
    }

    public void removeClinica(int idx) {
        clinicas.remove(idx);
    }

    public void removeInfante(int idx) {
        infantesRegion.remove(idx);
    }

    public void removeInfanteAtClinica(int cliIdx, int infIdx) {
        clinicas.get(cliIdx).removeFromMuestra(infIdx);
    }

    public ArrayList<Clinica> clinicasMasVacunas() {
        ArrayList<Clinica> cli = new ArrayList<>();
        Clinica c = clinicas.get(0);
        for (Clinica elem : clinicas) {
            if (elem.getVacunasTotal() > c.getVacunasTotal()) {
                c = elem;
            }
        }
        for (Clinica elem : clinicas) {
            int a = elem.getVacunasTotal();
            int b = c.getVacunasTotal();
            if (a == b) {
                cli.add(elem);
            }
        }
        return cli;
    }

    public boolean seleccionadoParaMuestra(String nombre) {
        for (Clinica cli : clinicas) {
            for (Infante inf : cli.getMuestra()) {
                if (inf.getNombre().equals(nombre)) {
                    return true;
                }
            }
        }
        return false;

    }

    public double edadPromedioEnClinica(ArrayList<Integer> id) {
        double prom = 0;
        for (Clinica cli : clinicas) {
            if (cli.getId() == id) {
                prom = 0;
                for (Infante inf : cli.getMuestra()) {
                    prom += inf.getEdad();
                }
                prom /= cli.getTamanoMuestra();
            }
        }
        return prom;
    }

    public ArrayList<Clinica> incumplieronVacunacion() {
        ArrayList<Clinica> cli = new ArrayList<>();
        for (Clinica elem : clinicas) {
            for (Integer vac : elem.getVacunas()) {
                if (vac == 0) {
                    cli.add(elem);
                    break;
                }
            }
        }
        return cli;
    }

    public void updateClinica(int idx, Clinica cli) {
        clinicas.set(idx, cli);
    }

    public boolean InfanteExists(Infante inf) {
        for (Infante infante : infantesRegion) {
            if (infante.getCedulaString().equals(inf.getCedulaString())) {
                return true;
            }
        }
        return false;
    }

    public boolean InfanteExistsInClinicas(Infante inf) {
        for(Clinica cli: clinicas){
            for (Infante infante : cli.getMuestra()) {
                if (infante.getCedulaString().equals(inf.getCedulaString())) {
                    return true;
                }
            }
        }
        return false;
    }
}
