package domain;

public class PlanillaDelMes {
    
    private int id_dia;
    private int cantidadDeViajes;
    private int ganancias;

    public int getId_dia() {
        return id_dia;
    }

    public void setId_dia(int id_dia) {
        this.id_dia = id_dia;
    }

    public int getCantidadDeViajes() {
        return cantidadDeViajes;
    }

    public void setCantidadDeViajes(int cantidadDeViajes) {
        this.cantidadDeViajes = cantidadDeViajes;
    }

    public int getGanancias() {
        return ganancias;
    }

    public void setGanancias(int ganancias) {
        this.ganancias = ganancias;
    }

    @Override
    public String toString() {
        return "PlanillaDelMes{" + "id_dia=" + id_dia + ", cantidadDeViajes=" + cantidadDeViajes + ", ganancias=" + ganancias + '}';
    }
    
    
    
}
