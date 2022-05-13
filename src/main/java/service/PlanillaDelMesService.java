package service;

import domain.PlanillaDelMes;

public interface PlanillaDelMesService {

    public void listarDias();

    public void nuevoDia();

    public void eliminarDia(PlanillaDelMes dia);
    
    public void limpiarPlanillaMensual();

    public int calcularGananciasMensuales();

}
