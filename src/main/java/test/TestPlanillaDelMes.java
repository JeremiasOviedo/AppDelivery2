package test;

import data.Conexion;
import domain.PlanillaDelMes;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import service.PlanillaDelDiaServiceImpl;
import service.PlanillaDelMesServiceImpl;

public class TestPlanillaDelMes {
    
    public static void main(String[] args) throws SQLException {

        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
           // PlanillaDelDiaServiceImpl viajeJDBC = new PlanillaDelDiaServiceImpl();
            PlanillaDelMesServiceImpl diaJDBC = new PlanillaDelMesServiceImpl();
          //  List<PlanillaDelMes> dias;
            PlanillaDelMes dia = new PlanillaDelMes();
            
            
           // dia.setId_dia(4);
            
            
            //diaJDBC.eliminarDia(dia);
           // diaJDBC.listarDias();
           
          diaJDBC.nuevoDia();
           diaJDBC.calcularGananciasMensuales();
            
            
            
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
