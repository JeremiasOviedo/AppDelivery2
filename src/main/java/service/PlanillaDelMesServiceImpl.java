package service;

import data.PlanillaDelMesDaoJDBC;
import domain.PlanillaDelMes;
import java.sql.SQLException;
import java.util.List;

public class PlanillaDelMesServiceImpl implements PlanillaDelMesService {

    PlanillaDelDiaServiceImpl planillaDelDia = new PlanillaDelDiaServiceImpl();
    PlanillaDelMesDaoJDBC planillaDelMesDao = new PlanillaDelMesDaoJDBC();

    
    //Itera e imprime los elementos de la planilla del mes
    @Override
    public void listarDias() {
        
        List<PlanillaDelMes> dias;
        try {
            dias = planillaDelMesDao.select();
            for (int i = 0; i < dias.size(); i++) {
                var dia = dias.get(i);
                System.out.println("Viaje:" + dia);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //Invoca el metodo cerrar dia de la planilla del dia y agrega el nuevo dia a la planilla del mes
    @Override
    public void nuevoDia() {
       
        PlanillaDelMes dia;
        
        dia = planillaDelDia.cerrarDia();
        try {
            planillaDelMesDao.insert(dia);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

    
    @Override
    public void eliminarDia(PlanillaDelMes dia) {
       
        try {
            planillaDelMesDao.delete(dia);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
   
    //elimina todos los elementos de la planilla del mes
   @Override
    public void limpiarPlanillaMensual(){
        
        try {
            planillaDelMesDao.deleteAll();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

  //calcula las ganancias que se llevan en el mes
    @Override
    public int calcularGananciasMensuales() {
        int gananciasMensuales = 0;

        List<PlanillaDelMes> dias;
        PlanillaDelMes dia;
        try {
            dias = planillaDelMesDao.select();
            for (int i = 0; i < dias.size(); i++) {
                dia = dias.get(i);
                gananciasMensuales += dia.getGanancias();
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        System.out.println("Ganancias: $" + gananciasMensuales);
        return gananciasMensuales;
    }

}
