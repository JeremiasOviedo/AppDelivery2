package data;

import domain.PlanillaDelDia;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

public class PlanillaDelDiaDaoJDBC implements PlanillaDelDiaDao {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT id_viaje, montoDelPedido, valorDelViaje FROM planilladeldia";
    private static final String SQL_INSERT = "INSERT INTO planilladeldia(montoDelPedido, valorDelViaje) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE planilladeldia SET montoDelPedido = ?, valorDelViaje = ? WHERE id_viaje= ?";
    private static final String SQL_DELETE = "DELETE FROM planilladeldia WHERE id_viaje= ?";
    private static final String SQL_DELETEALL = "DELETE FROM planilladeldia";

    public PlanillaDelDiaDaoJDBC() {

    }

    public PlanillaDelDiaDaoJDBC(Connection conexionTransaccional) {

        this.conexionTransaccional = conexionTransaccional;
    }

    public List<PlanillaDelDia> select() throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PlanillaDelDia viaje = null;
        List<PlanillaDelDia> viajes = new ArrayList<PlanillaDelDia>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int id_viaje = rs.getInt("id_viaje");
                int montoDelPedido = rs.getInt("montoDelPedido");
                int valorDelViaje = rs.getInt("valorDelViaje");

                viaje = new PlanillaDelDia();
                viaje.setId_viaje(id_viaje);
                viaje.setMontoDelPedido(montoDelPedido);
                viaje.setValorDelViaje(valorDelViaje);
                viajes.add(viaje);
            }

        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);

            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }

        }

        return viajes;
    }

    public int insert(PlanillaDelDia viaje) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, viaje.getMontoDelPedido());
            stmt.setInt(2, viaje.getValorDelViaje());

            System.out.println("Ejecutando Query: " + SQL_INSERT);
            stmt.executeUpdate();
            System.out.println("Cantidad de registros afectados: " + rows);

        } finally {

            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }

    public int update(PlanillaDelDia viaje) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, viaje.getMontoDelPedido());
            stmt.setInt(2, viaje.getValorDelViaje());
            stmt.setInt(3, viaje.getId_viaje());

            stmt.executeUpdate();
            System.out.println("Cantidad de registros actualizados: " + rows);
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }
        return rows;

    }

    public int delete(PlanillaDelDia viaje) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            System.out.println("Ejecutando Query: " + SQL_DELETE);

            stmt.setInt(1, viaje.getId_viaje());
            rows = stmt.executeUpdate();

            System.out.println("Elementos borrados con exito:" + rows);

        } finally {
            Conexion.close(stmt);

            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }

        }
        return rows;
    }
    
      public void deleteAll() throws SQLException {
          Connection conn = null;
          PreparedStatement stmt = null;
          
          try{
              conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
              stmt = conn.prepareStatement (SQL_DELETEALL);
              
              System.out.println("Borrando elementos");
              stmt.executeUpdate();
              System.out.println("Todos los elementos han sido borrados");
          }finally{
              Conexion.close(stmt);
              
              if (this.conexionTransaccional == null){
                  Conexion.close(conn);
                          }
              }
              
          }
      }

