// Importiamo le classi necessarie per gestire le date
import java.time.LocalDate; // Per lavorare con le date
import java.time.format.DateTimeFormatter; // Per formattare le date
import java.time.format.DateTimeParseException; // Per gestire errori di formato data

/**
 * Classe Evento - rappresenta un evento con titolo, data e gestione posti
 * Questa classe permette di creare eventi, prenotare e disdire posti
 */
public class Evento {
    // ATTRIBUTI DELLA CLASSE (variabili private per incapsulamento)
    
    private String titolo;        // Il nome dell'evento (es: "Concerto di Natale")
    private String data;          // La data dell'evento in formato yyyy-MM-dd (es: "2024-12-25")
    private int postiTotali;      // Numero massimo di posti disponibili per l'evento
    private int postiPrenotati;   // Numero di posti già prenotati (inizia da 0)
    
    /**
     * COSTRUTTORE - metodo speciale che viene chiamato quando creiamo un nuovo evento
     * @param titolo - il nome dell'evento
     * @param data - la data dell'evento in formato yyyy-MM-dd
     * @param postiTotali - il numero massimo di posti disponibili
     */
    public Evento(String titolo, String data, int postiTotali) {
        // CONTROLLO 1: Verifichiamo che il numero di posti sia valido
        // Non possiamo avere 0 o meno posti per un evento!
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo");
        }
        
        // CONTROLLO 2: Verifichiamo che la data sia valida e non nel passato
        // Usiamo un metodo helper (validaData) per fare questo controllo
        validaData(data);
        
        // Se tutti i controlli sono ok, assegniamo i valori agli attributi
        this.titolo = titolo;           // "this." indica che stiamo parlando dell'attributo della classe
        this.data = data;
        this.postiTotali = postiTotali;
        this.postiPrenotati = 0;        // All'inizio nessuno ha prenotato, quindi partiamo da 0
    }
    
    // METODI GETTER E SETTER - permettono di leggere e modificare gli attributi privati
    
    /**
     * GETTER per il titolo - restituisce il nome dell'evento
     * @return il titolo dell'evento
     */
    public String getTitolo() {
        return titolo;  // Restituiamo il valore dell'attributo titolo
    }
    
    /**
     * SETTER per il titolo - permette di cambiare il nome dell'evento
     * @param titolo - il nuovo titolo da assegnare
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;  // Assegniamo il nuovo valore all'attributo
    }
    
    /**
     * GETTER per la data - restituisce la data dell'evento
     * @return la data in formato yyyy-MM-dd
     */
    public String getData() {
        return data;  // Restituiamo il valore dell'attributo data
    }
    
    /**
     * SETTER per la data - permette di cambiare la data dell'evento
     * @param data - la nuova data in formato yyyy-MM-dd
     */
    public void setData(String data) {
        // Prima di cambiare la data, controlliamo che sia valida
        validaData(data);
        
        this.data = data;  // Se il controllo è ok, assegniamo la nuova data
    }
    
    /**
     * GETTER per posti totali - restituisce il numero massimo di posti
     * NOTA: Non c'è il setter perché i posti totali non dovrebbero cambiare dopo la creazione
     * @return il numero totale di posti disponibili
     */
    public int getPostiTotali() {
        return postiTotali;
    }
    
    /**
     * GETTER per posti prenotati - restituisce quanti posti sono già stati prenotati
     * NOTA: Non c'è il setter perché i posti prenotati cambiano solo con prenota() e disdici()
     * @return il numero di posti attualmente prenotati
     */
    public int getPostiPrenotati() {
        return postiPrenotati;
    }
    
    // METODI HELPER PRIVATI - metodi di supporto usati internamente dalla classe
    
    /**
     * Metodo privato per controllare se una data è valida
     * Controlla due cose:
     * 1. Che la data sia nel formato corretto (yyyy-MM-dd)
     * 2. Che la data non sia nel passato
     * @param data - la data da controllare
     */
    private void validaData(String data) {
        try {
            // Proviamo a convertire la stringa in una data
            // DateTimeFormatter.ofPattern("yyyy-MM-dd") dice che il formato deve essere anno-mese-giorno
            LocalDate dataEvento = LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            
            // Prendiamo la data di oggi per fare il confronto
            LocalDate oggi = LocalDate.now();
            
            // Se la data dell'evento è prima di oggi, è nel passato!
            if (dataEvento.isBefore(oggi)) {
                throw new IllegalArgumentException("La data dell'evento non può essere nel passato");
            }
        } catch (DateTimeParseException e) {
            // Se arriviamo qui, significa che la data non è nel formato giusto
            throw new IllegalArgumentException("Formato data non valido. Utilizzare il formato yyyy-MM-dd");
        }
    }
    
    /**
     * Metodo privato per controllare che l'evento non sia già passato
     * Viene usato prima di fare prenotazioni o disdette
     */
    private void validaEventoNonPassato() {
        // Convertiamo la data dell'evento in LocalDate
        LocalDate dataEvento = LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        // Prendiamo la data di oggi
        LocalDate oggi = LocalDate.now();
        
        // Se l'evento è già passato, non possiamo più modificare le prenotazioni
        if (dataEvento.isBefore(oggi)) {
            throw new IllegalArgumentException("Non è possibile modificare prenotazioni per un evento già passato");
        }
    }
    
    // METODI PUBBLICI - le funzionalità principali della classe
    
    /**
     * Metodo per prenotare un posto all'evento
     * Aumenta di 1 il numero di posti prenotati se possibile
     */
    public void prenota() {
        // CONTROLLO 1: Verifichiamo che l'evento non sia già passato
        validaEventoNonPassato();
        
        // CONTROLLO 2: Verifichiamo che ci siano ancora posti liberi
        // Se i posti prenotati sono già uguali (o maggiori) ai posti totali, non c'è più posto!
        if (postiPrenotati >= postiTotali) {
            throw new IllegalArgumentException("Non ci sono posti disponibili per questo evento");
        }
        
        // Se tutti i controlli sono ok, aggiungiamo una prenotazione
        // ++ significa "aumenta di 1"
        postiPrenotati++;
    }
    
    /**
     * Metodo per disdire una prenotazione
     * Diminuisce di 1 il numero di posti prenotati se possibile
     */
    public void disdici() {
        // CONTROLLO 1: Verifichiamo che l'evento non sia già passato
        validaEventoNonPassato();
        
        // CONTROLLO 2: Verifichiamo che ci siano prenotazioni da disdire
        // Se i posti prenotati sono 0 o meno, non c'è niente da disdire!
        if (postiPrenotati <= 0) {
            throw new IllegalArgumentException("Non ci sono prenotazioni da disdire");
        }
        
        // Se tutti i controlli sono ok, togliamo una prenotazione
        // -- significa "diminuisci di 1"
        postiPrenotati--;
    }
    
    /**
     * Metodo toString - definisce come viene mostrato l'evento quando lo stampiamo
     * @Override significa che stiamo sovrascrivendo il metodo toString della classe Object
     * @return una stringa nel formato "data - titolo"
     */
    @Override
    public String toString() {
        // Restituiamo una stringa che combina data e titolo con un trattino in mezzo
        return data + " - " + titolo;
    }
}