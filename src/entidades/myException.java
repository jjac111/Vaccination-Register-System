package entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author noel
 */
public class myException extends Exception {
    private String msg;
    private int code;
    public myException(String message) {
        super(message);
    }
    public myException(int code) {
        super("");
        this.code = code;
    }
    int getCode(){return code;}
    
    @Override
    public String getMessage() {
        switch (code){
            case 0:
                msg = "ERROR: No se puede:\n\tIngresar caracteres no numéricos\n\tExceder el máximo de dígitos de cédula: " + Infante.MAX_CEDULA_LENGTH; break;
            case 1:
                msg = "ERROR: No se puede:\\n\\tIngresar texto vacío\\n\\tIngresar caracteres no numéricos\\n\\tExceder el máximo de dígitos de ID: " + Clinica.MAX_ID_LENGTH; break;
            case 2:
                msg = "ERROR: El numero de vacunas excede la cantidad de infantes en la region."; break;
            case 3:
                msg = "ERROR: Ya existe un infante con igual cédula en una muestra de una clínica."; break;
            case 4:
                msg = "ERROR: Ya existe una factura con igual código."; break;
            case 5:
                msg = "ERROR: Ya existe el cliente."; break;
        }
        return msg;
    }
}
