// Importiamo LocalTime per creare gli orari dei concerti
import java.time.LocalTime;

/**
 * Classe TestConcerto - serve per testare tutte le funzionalità della classe Concerto
 * I test verificano che tutto funzioni correttamente e gestisca gli errori come previsto
 */
public class TestConcerto {
    /**
     * Metodo main - esegue tutti i test della classe Concerto
     * @param args - argomenti da riga di comando (non utilizzati)
     */
    public static void main(String[] args) {
        System.out.println("=== TEST CLASSE CONCERTO ===");
        
        try {
            // TEST 1: CREAZIONE DI UN CONCERTO
            // LocalTime.of(21, 30) crea un orario alle 21:30
            LocalTime oraConcerto = LocalTime.of(21, 30); // 21:30
            
            // Creiamo un concerto con tutti i parametri necessari
            Concerto concerto = new Concerto("Concerto Rock Festival", "2026-07-15", 5000, oraConcerto, 45.50);
            
            // Stampiamo il concerto per vedere come appare (usa il toString() personalizzato)
            System.out.println("Concerto creato: " + concerto);
            
            // TEST 2: VERIFICA DEI METODI GETTER
            // I getter servono per leggere i valori degli attributi privati
            System.out.println("\n=== TEST GETTER ===");
            System.out.println("Titolo: " + concerto.getTitolo());           // Ereditato da Evento
            System.out.println("Data: " + concerto.getData());               // Ereditato da Evento
            System.out.println("Ora: " + concerto.getOra());                 // Specifico di Concerto
            System.out.println("Prezzo: " + concerto.getPrezzo());           // Specifico di Concerto
            System.out.println("Posti totali: " + concerto.getPostiTotali()); // Ereditato da Evento
            System.out.println("Posti prenotati: " + concerto.getPostiPrenotati()); // Ereditato da Evento
            
            // TEST 3: VERIFICA DEI METODI DI FORMATTAZIONE
            // Questi metodi trasformano i dati in formato leggibile per l'utente
            System.out.println("\n=== TEST METODI FORMATTAZIONE ===");
            
            // getDataOraFormattata() converte "2026-07-15" + "21:30" in "15/07/2026 21:30"
            System.out.println("Data e ora formattata: " + concerto.getDataOraFormattata());
            
            // getPrezzoFormattato() converte 45.50 in "45.50€"
            System.out.println("Prezzo formattato: " + concerto.getPrezzoFormattato());
            
            // TEST 4: VERIFICA DEI METODI SETTER
            // I setter permettono di modificare i valori degli attributi
            System.out.println("\n=== TEST SETTER ===");
            
            // Modifichiamo tutti gli attributi per vedere se i setter funzionano
            concerto.setTitolo("Concerto Jazz & Blues");  // Cambiamo il titolo
            concerto.setData("2026-08-20");               // Cambiamo la data
            concerto.setOra(LocalTime.of(20, 0));          // Cambiamo l'ora (20:00)
            concerto.setPrezzo(55.75);                     // Cambiamo il prezzo
            
            // Stampiamo il concerto modificato per vedere i cambiamenti
            System.out.println("Dopo le modifiche: " + concerto);
            
            // TEST 5: VERIFICA DEI METODI EREDITATI DA EVENTO
            // Concerto eredita i metodi prenota() e disdici() dalla classe Evento
            System.out.println("\n=== TEST METODI EREDITATI ===");
            
            // Verifichiamo le prenotazioni
            System.out.println("Posti prenotati prima: " + concerto.getPostiPrenotati());
            
            // Facciamo 10 prenotazioni usando un ciclo for
            for (int i = 0; i < 10; i++) {
                concerto.prenota();  // Ogni chiamata aumenta di 1 i posti prenotati
            }
            System.out.println("Posti prenotati dopo 10 prenotazioni: " + concerto.getPostiPrenotati());
            
            // Calcoliamo e mostriamo i posti ancora disponibili
            int postiDisponibili = concerto.getPostiTotali() - concerto.getPostiPrenotati();
            System.out.println("Posti disponibili: " + postiDisponibili);
            
            // Ora testiamo le disdette (cancellazioni)
            System.out.println("\nTest disdette:");
            
            // Facciamo 3 disdette
            for (int i = 0; i < 3; i++) {
                concerto.disdici();  // Ogni chiamata diminuisce di 1 i posti prenotati
            }
            System.out.println("Posti prenotati dopo 3 disdette: " + concerto.getPostiPrenotati());
            
            // Ricalcoliamo i posti disponibili dopo le disdette
            int nuoviPostiDisponibili = concerto.getPostiTotali() - concerto.getPostiPrenotati();
            System.out.println("Posti disponibili: " + nuoviPostiDisponibili);
            
            System.out.println("\nStato finale del concerto: " + concerto);
            
            // TEST 6: VERIFICA DELLE VALIDAZIONI E GESTIONE ERRORI
            // Testiamo che il programma gestisca correttamente le situazioni di errore
            System.out.println("\n=== TEST VALIDAZIONI ===");
            
            // Test: cosa succede se proviamo a prenotare più posti di quelli disponibili?
            try {
                // Creiamo un concerto con solo 2 posti
                Concerto concertoPiccolo = new Concerto("Concerto Intimo", "2026-09-10", 2, LocalTime.of(19, 0), 25.0);
                
                // Prenotiamo tutti i posti disponibili
                concertoPiccolo.prenota();  // Posto 1
                concertoPiccolo.prenota();  // Posto 2
                System.out.println("Concerto piccolo pieno: " + concertoPiccolo);
                
                // Ora proviamo a prenotare un terzo posto - questo DEVE fallire!
                concertoPiccolo.prenota();
            } catch (IllegalArgumentException e) {
                // Se arriviamo qui, significa che l'errore è stato gestito correttamente
                System.out.println("Errore prenotazione (atteso): " + e.getMessage());
            }
            
            // Test: cosa succede se proviamo a disdire quando non ci sono prenotazioni?
            try {
                // Creiamo un concerto senza prenotazioni
                Concerto concertoVuoto = new Concerto("Concerto Vuoto", "2026-10-05", 100, LocalTime.of(18, 30), 30.0);
                
                // Proviamo a disdire senza aver mai prenotato - questo DEVE fallire!
                concertoVuoto.disdici();
            } catch (IllegalArgumentException e) {
                // Se arriviamo qui, l'errore è stato gestito correttamente
                System.out.println("Errore disdetta (atteso): " + e.getMessage());
            }
            
            // Test: cosa succede se proviamo a creare un concerto con data nel passato?
            try {
                // Proviamo a creare un concerto nel 2020 (nel passato) - questo DEVE fallire!
                Concerto concertoPassato = new Concerto("Concerto Passato", "2020-01-01", 100, LocalTime.of(20, 0), 40.0);
            } catch (IllegalArgumentException e) {
                // Se arriviamo qui, la validazione della data ha funzionato
                System.out.println("Errore data passata (atteso): " + e.getMessage());
            }
            
            // TEST 7: VERIFICA FORMATTAZIONE PREZZI DIVERSI
            // Testiamo che la formattazione dei prezzi funzioni con valori diversi
            System.out.println("\n=== TEST FORMATI PREZZO ===");
            
            // Creiamo concerti con prezzi diversi per testare la formattazione
            Concerto concerto1 = new Concerto("Test Prezzo 1", "2026-11-01", 100, LocalTime.of(19, 0), 12.5);   // 12.50€
            Concerto concerto2 = new Concerto("Test Prezzo 2", "2026-11-02", 100, LocalTime.of(19, 0), 99.99);  // 99.99€
            Concerto concerto3 = new Concerto("Test Prezzo 3", "2026-11-03", 100, LocalTime.of(19, 0), 5.0);    // 5.00€
            
            // Stampiamo tutti i concerti per vedere come vengono formattati i prezzi
            System.out.println("Concerto 1: " + concerto1);  // Dovrebbe mostrare 12.50€
            System.out.println("Concerto 2: " + concerto2);  // Dovrebbe mostrare 99.99€
            System.out.println("Concerto 3: " + concerto3);  // Dovrebbe mostrare 5.00€
            
        } catch (Exception e) {
            System.err.println("Errore durante i test: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("\n=== FINE TEST ===");
    }
}