package data;

import domain.PlanillaDelMes;
import java.sql.*;
import java.util.*;

public class PlanillaDelMesDaoJDBC implements PlanillaDelMesDao {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT id_dia,cantidadDeViajes,ganancias FROM planilladelmes";
    private static final String SQL_INSERT = "INSERT INTO planilladelmes (cantidadDeViajes, ganancias) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE planilladelmes SET cantidadDeViajes=?,ganancias=? WHERE id_dia=?";
    private static final String SQL_DELETE = "DELETE FROM planillaDelMes WHERE id_dia= ?";
    private static final String SQL_DELETEALL = "DELETE FROM planillaDelMes";

    public PlanillaDelMesDaoJDBC() {

    }

    public PlanillaDelMesDaoJDBC(Connection conexionTransaccinal) {

        this.conexionTransaccional = conexionTransaccional;
    }

    public List<PlanillaDelMes> select() throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PlanillaDelMes dia = null;
        List<PlanillaDelMes> dias = new ArrayList<PlanillaDelMes>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int id_dia = rs.getInt("id_dia");
                int cantidadDeViajes = rs.getInt("cantidadDeViajes");
                int ganancias = rs.getInt("ganancias");

                dia = new PlanillaDelMes();
                dia.setId_dia(id_dia);
                dia.setCantidadDeViajes(cantidadDeViajes);
                dia.setGanancias(ganancias);
                dias.add(dia);
            }
        } finally {
            Conexion.close(stmt);
            Conexion.close(rs);

            if (this.conexionTransaccional == null) {
                Conexion.close(conn);

            }
        }
        return dias;

    }

    public int insert(PlanillaDelMes dia) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, dia.getCantidadDeViajes());
            stmt.setInt(2, dia.getGanancias());

            System.out.println("Ejecutando Query:" + SQL_INSERT);
            stmt.executeUpdate();
            System.out.println("Dia agregado con exito");
        } finally {
            Conexion.close(stmt);

            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;

    }

    public int update(PlanillaDelMes dia) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setInt(1, dia.getCantidadDeViajes());
            stmt.setInt(2, dia.getGanancias());
            stmt.setInt(3, dia.getId_dia());

            System.out.println("Ejectuando Query: " + SQL_UPDATE);
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

    public int delete(PlanillaDelMes dia) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, dia.getId_dia());
            System.out.println("Ejecutando Query: " + SQL_DELETE);
            stmt.executeUpdate();
            System.out.println("Registros borrados exitosxamente: " + rows);

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
        
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETEALL);
            
            System.out.println("Ejectuando Query:" + SQL_DELETEALL);
            System.out.println("Borrando Elementos");
            stmt.executeUpdate();
            System.out.println("Elementos borrados exitosamente");
                    
        }finally{
            Conexion.close(stmt);
            if(this.conexionTransaccional == null){
                Conexion.close(conn);
            }
        }
    }

}
