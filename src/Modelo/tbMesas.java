package Modelo;

public class tbMesas {
    private int idMesa;
    private String EstadoMesa;
    private int idCliente;
    private int idEmpleado;

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getEstadoMesa() {
        return EstadoMesa;
    }

    public void setEstadoMesa(String EstadoMesa) {
        this.EstadoMesa = EstadoMesa;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
