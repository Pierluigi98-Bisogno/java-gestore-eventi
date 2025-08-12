import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;

public class Concerto extends Evento {
    // Attributi aggiuntivi
    private LocalTime ora;
    private double prezzo;
    
    // Costruttore
    public Concerto(String titolo, String data, int postiTotali, LocalTime ora, double prezzo) {
        super(titolo, data, postiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }
    
    // Getter e Setter per ora
    public LocalTime getOra() {
        return ora;
    }
    
    public void setOra(LocalTime ora) {
        this.ora = ora;
    }
    
    // Getter e Setter per prezzo
    public double getPrezzo() {
        return prezzo;
    }
    
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    
    // Metodo per restituire data e ora formattata
    public String getDataOraFormattata() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoOra = DateTimeFormatter.ofPattern("HH:mm");
        return getData().replace("-", "/").substring(8) + "/" + 
               getData().replace("-", "/").substring(5, 7) + "/" + 
               getData().replace("-", "/").substring(0, 4) + " " + 
               ora.format(formatoOra);
    }
    
    // Metodo per restituire prezzo formattato
    public String getPrezzoFormattato() {
        DecimalFormat formato = new DecimalFormat("#0.00€");
        return formato.format(prezzo);
    }
    
    // Override del metodo toString
    @Override
    public String toString() {
        return getDataOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }
}