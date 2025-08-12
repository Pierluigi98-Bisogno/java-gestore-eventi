// Importiamo le classi necessarie per gestire orari e formattazione
import java.time.LocalTime; // Per gestire gli orari (ore e minuti)
import java.time.format.DateTimeFormatter; // Per formattare date e orari
import java.text.DecimalFormat; // Per formattare i prezzi con decimali

/**
 * Classe Concerto - estende la classe Evento aggiungendo ora e prezzo
 * "extends Evento" significa che Concerto EREDITA tutto da Evento
 * (attributi, metodi, costruttore) e può aggiungere le sue funzionalità
 */
public class Concerto extends Evento {
    // ATTRIBUTI AGGIUNTIVI - oltre a quelli ereditati da Evento
    
    private LocalTime ora;    // L'orario del concerto (es: 20:30)
    private double prezzo;    // Il prezzo del biglietto in euro (es: 25.50)
    
    /**
     * COSTRUTTORE - crea un nuovo concerto
     * @param titolo - il nome del concerto
     * @param data - la data in formato yyyy-MM-dd
     * @param postiTotali - numero massimo di posti
     * @param ora - l'orario del concerto
     * @param prezzo - il prezzo del biglietto
     */
    public Concerto(String titolo, String data, int postiTotali, LocalTime ora, double prezzo) {
        // super() chiama il costruttore della classe padre (Evento)
        // Questo inizializza titolo, data, postiTotali e postiPrenotati
        super(titolo, data, postiTotali);
        
        // Ora inizializziamo gli attributi specifici del Concerto
        this.ora = ora;       // Assegniamo l'orario
        this.prezzo = prezzo; // Assegniamo il prezzo
    }
    
    // GETTER E SETTER per i nuovi attributi
    
    /**
     * GETTER per l'ora - restituisce l'orario del concerto
     * @return l'orario come LocalTime
     */
    public LocalTime getOra() {
        return ora;  // Restituiamo l'orario
    }
    
    /**
     * SETTER per l'ora - permette di cambiare l'orario del concerto
     * @param ora - il nuovo orario
     */
    public void setOra(LocalTime ora) {
        this.ora = ora;  // Assegniamo il nuovo orario
    }
    
    /**
     * GETTER per il prezzo - restituisce il prezzo del biglietto
     * @return il prezzo come numero decimale
     */
    public double getPrezzo() {
        return prezzo;  // Restituiamo il prezzo
    }
    
    /**
     * SETTER per il prezzo - permette di cambiare il prezzo del biglietto
     * @param prezzo - il nuovo prezzo
     */
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;  // Assegniamo il nuovo prezzo
    }
    
    /**
     * Metodo per ottenere data e ora in formato leggibile
     * Converte da "2024-12-25" e "20:30" a "25/12/2024 20:30"
     * @return stringa con data e ora formattate
     */
    public String getDataOraFormattata() {
        // Creiamo i formattatori per data e ora
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoOra = DateTimeFormatter.ofPattern("HH:mm");
        
        // Prendiamo la data dalla classe padre e la trasformiamo
        // Da "2024-12-25" estraiamo le parti e le riordiniamo
        String dataOriginale = getData(); // Es: "2024-12-25"
        
        // substring(8) prende dal carattere 8 in poi = "25" (giorno)
        // substring(5, 7) prende dal carattere 5 al 7 = "12" (mese)
        // substring(0, 4) prende dal carattere 0 al 4 = "2024" (anno)
        return dataOriginale.substring(8) + "/" +     // giorno
               dataOriginale.substring(5, 7) + "/" + // mese
               dataOriginale.substring(0, 4) + " " + // anno
               ora.format(formatoOra);               // ora formattata
    }
    
    /**
     * Metodo per ottenere il prezzo in formato leggibile con il simbolo €
     * Converte da 25.5 a "25.50€"
     * @return stringa con prezzo formattato
     */
    public String getPrezzoFormattato() {
        // DecimalFormat ci permette di formattare i numeri
        // "#0.00€" significa: almeno uno zero prima della virgola, sempre due decimali, poi €
        DecimalFormat formato = new DecimalFormat("#0.00€");
        return formato.format(prezzo);  // Applichiamo il formato al prezzo
    }
    
    /**
     * Override del metodo toString - definisce come viene mostrato il concerto
     * @Override significa che stiamo sostituendo il toString della classe Evento
     * @return stringa nel formato "data ora - titolo - prezzo"
     */
    @Override
    public String toString() {
        // Combiniamo data/ora formattata, titolo (dalla classe padre) e prezzo formattato
        // Es: "25/12/2024 20:30 - Concerto di Natale - 25.50€"
        return getDataOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }
}