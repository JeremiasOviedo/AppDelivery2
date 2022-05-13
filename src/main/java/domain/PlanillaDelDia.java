package domain;

public class PlanillaDelDia {
    
    private int id_viaje;
    private int montoDelPedido;
    private int valorDelViaje;

    public int getId_viaje() {
        return id_viaje;
    }

    public void setId_viaje(int id_viaje) {
        this.id_viaje = id_viaje;
    }

    public int getMontoDelPedido() {
        return montoDelPedido;
    }

    public void setMontoDelPedido(int montoDelPedido) {
        this.montoDelPedido = montoDelPedido;
    }

    public int getValorDelViaje() {
        return valorDelViaje;
    }

    public void setValorDelViaje(int valorDelViaje) {
        this.valorDelViaje = valorDelViaje;
    }

    @Override
    public String toString() {
        return "PlanillaDelDia{" + "id_viaje=" + id_viaje + ", montoDelPedido=" + montoDelPedido + ", valorDelViaje=" + valorDelViaje + '}';
    }
    
    
}
