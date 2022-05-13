package test;

import data.Conexion;
import domain.PlanillaDelDia;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import service.PlanillaDelDiaServiceImpl;

public class TestPlanillaDelDia {

    public static void main(String[] args) throws SQLException {

        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            PlanillaDelDiaServiceImpl viajeJDBC = new PlanillaDelDiaServiceImpl();
            PlanillaDelDia viaje = new PlanillaDelDia();
            
            viaje.setMontoDelPedido(12500);
            viaje.setValorDelViaje(250);
            viaje.setId_viaje(2);
           
            
            viajeJDBC.editarViaje(viaje);
            viajeJDBC.listarViajes();
            viajeJDBC.calcularCantidadDeViajes();
            viajeJDBC.calcularGanancias();
            viajeJDBC.calcularMontoTotal();
            
            conexion.commit();
            System.out.println("Transaccion exitosa, se ha hecho commit");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al RollBack");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);

            }
        }
    }
}
