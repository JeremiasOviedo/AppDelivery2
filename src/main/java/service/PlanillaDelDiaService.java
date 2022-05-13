package service;

import domain.PlanillaDelDia;
import domain.PlanillaDelMes;
import java.util.List;

public interface PlanillaDelDiaService {

    public void listarViajes();

    public void nuevoViaje(PlanillaDelDia viaje);
    
    public void editarViaje(PlanillaDelDia viaje);

    public void eliminarViaje(PlanillaDelDia viaje);
    
    public void limpiarPlanillaDiaria();

    public int calcularCantidadDeViajes();
    
    public int calcularGanancias ();

    public int calcularMontoTotal();

    public PlanillaDelMes cerrarDia();
}
