import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Evento {
    // Proprietà
    private String titolo;
    private String data;
    private int postiTotali;
    private int postiPrenotati;
    
    // Costruttore
    public Evento(String titolo, String data, int postiTotali) {
        // Validazione posti totali
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo");
        }
        
        // Validazione data
        try {
            LocalDate dataEvento = LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate oggi = LocalDate.now();
            if (dataEvento.isBefore(oggi)) {
                throw new IllegalArgumentException("La data dell'evento non può essere nel passato");
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato data non valido. Utilizzare il formato yyyy-MM-dd");
        }
        
        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
        this.postiPrenotati = 0; // Inizializzato a 0
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
        // Validazione data
        try {
            LocalDate dataEvento = LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate oggi = LocalDate.now();
            if (dataEvento.isBefore(oggi)) {
                throw new IllegalArgumentException("La data dell'evento non può essere nel passato");
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato data non valido. Utilizzare il formato yyyy-MM-dd");
        }
        
        this.data = data;
    }
    
    // Getter per posti totali (solo lettura)
    public int getPostiTotali() {
        return postiTotali;
    }
    
    // Getter per posti prenotati (solo lettura)
    public int getPostiPrenotati() {
        return postiPrenotati;
    }
    
    // Metodo per prenotare un posto
    public void prenota() {
        // Verifica se l'evento è già passato
        LocalDate dataEvento = LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate oggi = LocalDate.now();
        if (dataEvento.isBefore(oggi)) {
            throw new IllegalArgumentException("Non è possibile prenotare per un evento già passato");
        }
        
        // Verifica se ci sono posti disponibili
        if (postiPrenotati >= postiTotali) {
            throw new IllegalArgumentException("Non ci sono posti disponibili per questo evento");
        }
        
        // Incrementa i posti prenotati
        postiPrenotati++;
    }
    
    // Metodo toString per visualizzare l'evento
    @Override
    public String toString() {
        return "Evento: " + titolo + " - Data: " + data + " - Posti totali: " + postiTotali + " - Posti prenotati: " + postiPrenotati;
    }
}