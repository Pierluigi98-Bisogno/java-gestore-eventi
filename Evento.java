public class Evento {
    // Proprietà
    private String titolo;
    private String data;
    
    // Costruttore
    public Evento(String titolo, String data) {
        this.titolo = titolo;
        this.data = data;
    }
    
    // Getter
    public String getTitolo() {
        return titolo;
    }
    
    // Setter
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    
    // Getter per data
    public String getData() {
        return data;
    }
    
    // Setter per data
    public void setData(String data) {
        this.data = data;
    }
    
    // Metodo toString per visualizzare l'evento
    @Override
    public String toString() {
        return "Evento: " + titolo + " - Data: " + data;
    }
}