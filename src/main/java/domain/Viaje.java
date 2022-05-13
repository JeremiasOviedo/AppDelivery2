package domain;

public class Viaje {

    private int valorViajeBasico;
    private int valorViajeLargo;

    public int getValorViajeBasico() {
        return valorViajeBasico;
    }

    public void setValorViajeBasico(int valorViajeBasico) {
        this.valorViajeBasico = valorViajeBasico;
    }

    public int getValorViajeLargo() {
        return valorViajeLargo;
    }

    public void setValorViajeLargo(int valorViajeLargo) {
        this.valorViajeLargo = valorViajeLargo;
    }

    @Override
    public String toString() {
        return "Viaje{" + "valorViajeBasico=" + valorViajeBasico + ", valorViajeLargo=" + valorViajeLargo + '}';
    }

  

}
