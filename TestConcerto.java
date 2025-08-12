import java.time.LocalTime;

public class TestConcerto {
    public static void main(String[] args) {
        System.out.println("=== TEST CLASSE CONCERTO ===");
        
        try {
            // Creazione di un concerto
            LocalTime oraConcerto = LocalTime.of(21, 30); // 21:30
            Concerto concerto = new Concerto("Concerto Rock Festival", "2026-07-15", 5000, oraConcerto, 45.50);
            
            System.out.println("Concerto creato: " + concerto);
            
            // Test dei getter
            System.out.println("\n=== TEST GETTER ===");
            System.out.println("Titolo: " + concerto.getTitolo());
            System.out.println("Data: " + concerto.getData());
            System.out.println("Ora: " + concerto.getOra());
            System.out.println("Prezzo: " + concerto.getPrezzo());
            System.out.println("Posti totali: " + concerto.getPostiTotali());
            System.out.println("Posti prenotati: " + concerto.getPostiPrenotati());
            
            // Test dei metodi di formattazione
            System.out.println("\n=== TEST METODI FORMATTAZIONE ===");
            System.out.println("Data e ora formattata: " + concerto.getDataOraFormattata());
            System.out.println("Prezzo formattato: " + concerto.getPrezzoFormattato());
            
            // Test dei setter
            System.out.println("\n=== TEST SETTER ===");
            concerto.setTitolo("Concerto Jazz & Blues");
            concerto.setData("2026-08-20");
            concerto.setOra(LocalTime.of(20, 0)); // 20:00
            concerto.setPrezzo(55.75);
            
            System.out.println("Dopo le modifiche: " + concerto);
            
            // Test dei metodi ereditati da Evento
            System.out.println("\n=== TEST METODI EREDITATI ===");
            
            // Test prenotazioni
            System.out.println("Posti prenotati prima: " + concerto.getPostiPrenotati());
            
            // Effettuiamo alcune prenotazioni
            for (int i = 0; i < 10; i++) {
                concerto.prenota();
            }
            System.out.println("Posti prenotati dopo 10 prenotazioni: " + concerto.getPostiPrenotati());
            System.out.println("Posti disponibili: " + (concerto.getPostiTotali() - concerto.getPostiPrenotati()));
            
            // Test disdette
            System.out.println("\nTest disdette:");
            for (int i = 0; i < 3; i++) {
                concerto.disdici();
            }
            System.out.println("Posti prenotati dopo 3 disdette: " + concerto.getPostiPrenotati());
            System.out.println("Posti disponibili: " + (concerto.getPostiTotali() - concerto.getPostiPrenotati()));
            
            System.out.println("\nStato finale del concerto: " + concerto);
            
            // Test delle validazioni
            System.out.println("\n=== TEST VALIDAZIONI ===");
            
            // Test prenotazione oltre la capacità
            try {
                Concerto concertoPiccolo = new Concerto("Concerto Intimo", "2026-09-10", 2, LocalTime.of(19, 0), 25.0);
                concertoPiccolo.prenota();
                concertoPiccolo.prenota();
                System.out.println("Concerto piccolo pieno: " + concertoPiccolo);
                
                // Questa dovrebbe fallire
                concertoPiccolo.prenota();
            } catch (IllegalArgumentException e) {
                System.out.println("Errore prenotazione (atteso): " + e.getMessage());
            }
            
            // Test disdetta senza prenotazioni
            try {
                Concerto concertoVuoto = new Concerto("Concerto Vuoto", "2026-10-05", 100, LocalTime.of(18, 30), 30.0);
                concertoVuoto.disdici(); // Questa dovrebbe fallire
            } catch (IllegalArgumentException e) {
                System.out.println("Errore disdetta (atteso): " + e.getMessage());
            }
            
            // Test creazione concerto con data passata
            try {
                Concerto concertoPassato = new Concerto("Concerto Passato", "2020-01-01", 100, LocalTime.of(20, 0), 40.0);
            } catch (IllegalArgumentException e) {
                System.out.println("Errore data passata (atteso): " + e.getMessage());
            }
            
            // Test con diversi formati di prezzo
            System.out.println("\n=== TEST FORMATI PREZZO ===");
            Concerto concerto1 = new Concerto("Test Prezzo 1", "2026-11-01", 100, LocalTime.of(19, 0), 12.5);
            Concerto concerto2 = new Concerto("Test Prezzo 2", "2026-11-02", 100, LocalTime.of(19, 0), 99.99);
            Concerto concerto3 = new Concerto("Test Prezzo 3", "2026-11-03", 100, LocalTime.of(19, 0), 5.0);
            
            System.out.println("Concerto 1: " + concerto1);
            System.out.println("Concerto 2: " + concerto2);
            System.out.println("Concerto 3: " + concerto3);
            
        } catch (Exception e) {
            System.err.println("Errore durante i test: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("\n=== FINE TEST ===");
    }
}