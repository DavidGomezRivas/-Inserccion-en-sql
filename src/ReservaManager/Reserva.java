package ReservaManager;

public class Reserva {
    private String nombre;
    private String telefono;
    private String fechaEvento;
    private String tipoEvento;
    private String nPersonas;
    private String tipoCocina;
    private String nJornadas;
    private String nHabitaciones;
    private String tipoMesa;
    private String nComensales;

    // Constructor
    public Reserva(String nombre, String telefono, String fechaEvento, String tipoEvento, String nPersonas, String tipoCocina, String nJornadas, String nHabitaciones, String tipoMesa, String nComensales) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaEvento = fechaEvento;
        this.tipoEvento = tipoEvento;
        this.nPersonas = nPersonas;
        this.tipoCocina = tipoCocina;
        this.nJornadas = nJornadas;
        this.nHabitaciones = nHabitaciones;
        this.tipoMesa = tipoMesa;
        this.nComensales = nComensales;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getNPersonas() {
        return nPersonas;
    }

    public void setNPersonas(String nPersonas) {
        this.nPersonas = nPersonas;
    }

    public String getTipoCocina() {
        return tipoCocina;
    }

    public void setTipoCocina(String tipoCocina) {
        this.tipoCocina = tipoCocina;
    }

    public String getNJornadas() {
        return nJornadas;
    }

    public void setNJornadas(String nJornadas) {
        this.nJornadas = nJornadas;
    }

    public String getNHabitaciones() {
        return nHabitaciones;
    }

    public void setNHabitaciones(String nHabitaciones) {
        this.nHabitaciones = nHabitaciones;
    }

    public String getTipoMesa() {
        return tipoMesa;
    }

    public void setTipoMesa(String tipoMesa) {
        this.tipoMesa = tipoMesa;
    }

    public String getNComensales() {
        return nComensales;
    }

    public void setNComensales(String nComensales) {
        this.nComensales = nComensales;
    }
}
