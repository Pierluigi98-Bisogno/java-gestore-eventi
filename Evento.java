public class Evento {
    // Proprietà
    private String titolo;
    
    // Costruttore
    public Evento(String titolo) {
        this.titolo = titolo;
    }
    
    // Getter
    public String getTitolo() {
        return titolo;
    }
    
    // Setter
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    
    // Metodo toString per visualizzare l'evento
    @Override
    public String toString() {
        return "Evento: " + titolo;
    }
}