package service;

import data.PlanillaDelDiaDaoJDBC;
import domain.PlanillaDelDia;
import domain.PlanillaDelMes;
import java.sql.SQLException;
import java.util.List;

public class PlanillaDelDiaServiceImpl implements PlanillaDelDiaService {

    PlanillaDelDiaDaoJDBC planillaDelDiaDao = new PlanillaDelDiaDaoJDBC();

   //Lista los elementos de la planilla del dia
    
    @Override
    public void listarViajes() {          

        List<PlanillaDelDia> viajes;
        try {
            viajes = planillaDelDiaDao.select();
            for (int i = 0; i < viajes.size(); i++) {

                var viaje = viajes.get(i);
                System.out.println("Viaje:" + viaje);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

    //agrega un nuevo viaje a la planilla del dia
    @Override
    public void nuevoViaje(PlanillaDelDia viaje) {

        try {
            planillaDelDiaDao.insert(viaje);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    @Override
    public void editarViaje(PlanillaDelDia viaje) {
        try {
            planillaDelDiaDao.update(viaje);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarViaje(PlanillaDelDia viaje) {
        try {
            planillaDelDiaDao.delete(viaje);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
  
    //borra todos los elementos de la planilla del dia
    @Override
    public void limpiarPlanillaDiaria() {

       try{
           planillaDelDiaDao.deleteAll();
       } catch (SQLException ex) {
           ex.printStackTrace(System.out);
       }
    }

    @Override
    public int calcularCantidadDeViajes() {

        int cantidadDeViajes = 0;

        List<PlanillaDelDia> viajes;
        try {
            viajes = planillaDelDiaDao.select();
            cantidadDeViajes = viajes.size();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        System.out.println("Cantidad de viajes:" + cantidadDeViajes);
        return cantidadDeViajes;

    }
//Calcula las ganancias del dia
    @Override
    public int calcularGanancias() {

        int ganancias = 0;

        List<PlanillaDelDia> viajes;
        PlanillaDelDia viaje;
        try {
            viajes = planillaDelDiaDao.select();
            for (int i = 0; i < viajes.size(); i++) {
                viaje = viajes.get(i);
                ganancias += viaje.getValorDelViaje();
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        System.out.println("Ganancias: $" + ganancias);
        return ganancias;

    }
//Calcula el monto total que el delivery debe abonar al local
    @Override
    public int calcularMontoTotal() {

        int montoTotal = 0;

        List<PlanillaDelDia> viajes;
        PlanillaDelDia viaje;
        try {
            viajes = planillaDelDiaDao.select();
            for (int i = 0; i < viajes.size(); i++) {
                viaje = viajes.get(i);
                montoTotal += viaje.getMontoDelPedido();
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        System.out.println("Total a pagar: $" + montoTotal);
        return montoTotal;

    }

    
    // Este metodo calcula las ganancias del dia y la cantidad de viajes y crea un elemento del tipo PlanillaDelMes para que se pueda agregar 
    // a la planilla del mes. Luego borra todos los elementos de la planilla del dia para que pueda volver a utilizarse
    @Override
    public PlanillaDelMes cerrarDia() {
        PlanillaDelMes dia = new PlanillaDelMes();

        int cantidadDeViajes;
        int ganancias;

        cantidadDeViajes = calcularCantidadDeViajes();
        ganancias = calcularGanancias();

        dia.setCantidadDeViajes(cantidadDeViajes);
        dia.setGanancias(ganancias);
        limpiarPlanillaDiaria();
        
        return dia;
        
        

    }

}
