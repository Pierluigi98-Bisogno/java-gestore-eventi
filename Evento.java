public class Evento {
    // Proprietà
    private String titolo;
    private String data;
    private int postiTotali;
    private int postiPrenotati;
    
    // Costruttore
    public Evento(String titolo, String data, int postiTotali, int postiPrenotati) {
        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
        this.postiPrenotati = postiPrenotati;
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
    
    // Getter per posti totali
    public int getPostiTotali() {
        return postiTotali;
    }
    
    // Setter per posti totali
    public void setPostiTotali(int postiTotali) {
        this.postiTotali = postiTotali;
    }
    
    // Getter per posti prenotati
    public int getPostiPrenotati() {
        return postiPrenotati;
    }
    
    // Setter per posti prenotati
    public void setPostiPrenotati(int postiPrenotati) {
        this.postiPrenotati = postiPrenotati;
    }
    
    // Metodo toString per visualizzare l'evento
    @Override
    public String toString() {
        return "Evento: " + titolo + " - Data: " + data + " - Posti totali: " + postiTotali + " - Posti prenotati: " + postiPrenotati;
    }
}