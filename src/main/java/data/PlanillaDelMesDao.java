package data;

import domain.PlanillaDelMes;
import java.sql.SQLException;
import java.util.*;

public interface PlanillaDelMesDao {
    
    public List<PlanillaDelMes> select() throws SQLException;
    
    public int insert(PlanillaDelMes dia) throws SQLException;
    public int update(PlanillaDelMes dia) throws SQLException;
    public int delete (PlanillaDelMes dia) throws SQLException;
    public void deleteAll() throws SQLException;
    
    
    
}
