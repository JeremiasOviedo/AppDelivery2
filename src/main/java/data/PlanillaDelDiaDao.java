package data;

import domain.PlanillaDelDia;
import java.sql.SQLException;
import java.util.*;

public interface PlanillaDelDiaDao {
    
    public List<PlanillaDelDia> select() throws SQLException;
    
    public int insert(PlanillaDelDia viaje) throws SQLException;
    public int update(PlanillaDelDia viaje) throws SQLException;
    public int delete (PlanillaDelDia viaje) throws SQLException;
    public void deleteAll() throws SQLException;
    
    
}
