public class Main {
    public static void main(String[] args) {
        try {
            // Creazione di alcuni eventi di esempio
            Evento concerto = new Evento("Concerto di Rock", "2025-06-15", 5000);
            Evento conferenza = new Evento("Conferenza sulla Tecnologia", "2025-07-20", 200);
            Evento spettacolo = new Evento("Spettacolo Teatrale", "2025-08-10", 300);
        
        // Stampa degli eventi
        System.out.println(concerto);
        System.out.println(conferenza);
        System.out.println(spettacolo);
        
            // Test dei metodi getter e setter
            System.out.println("\nTitolo del primo evento: " + concerto.getTitolo());
            System.out.println("Data del primo evento: " + concerto.getData());
            System.out.println("Posti totali del primo evento: " + concerto.getPostiTotali());
            System.out.println("Posti prenotati del primo evento: " + concerto.getPostiPrenotati());
            
            // Modifica del titolo e prenotazioni
            concerto.setTitolo("Concerto di Jazz");
            
            // Test del metodo prenota
            System.out.println("\n--- Test prenotazioni ---");
            System.out.println("Posti prenotati prima: " + concerto.getPostiPrenotati());
            
            // Prenotiamo alcuni posti
            for (int i = 0; i < 5; i++) {
                concerto.prenota();
            }
            System.out.println("Posti prenotati dopo 5 prenotazioni: " + concerto.getPostiPrenotati());
            
            System.out.println("Evento modificato: " + concerto);
            
        } catch (IllegalArgumentException e) {
            System.err.println("Errore nella creazione dell'evento: " + e.getMessage());
        }
        
        // Test delle validazioni
        System.out.println("\n--- Test delle validazioni ---");
        
        // Test data nel passato
        try {
            Evento eventoPassato = new Evento("Evento Passato", "2020-01-01", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore data passata: " + e.getMessage());
        }
        
        // Test posti negativi
        try {
            Evento eventoPostiNegativi = new Evento("Evento Posti Negativi", "2025-12-31", -50);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore posti negativi: " + e.getMessage());
        }
        
        // Test formato data non valido
        try {
            Evento eventoDataInvalida = new Evento("Evento Data Invalida", "31/12/2025", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore formato data: " + e.getMessage());
        }
        
        // Test setter data con validazione
        System.out.println("\n--- Test setter data ---");
        try {
            Evento eventoTest = new Evento("Evento Test", "2025-12-31", 100);
            System.out.println("Evento creato: " + eventoTest);
            
            // Test modifica data valida
            eventoTest.setData("2025-11-15");
            System.out.println("Data modificata con successo: " + eventoTest);
            
            // Test modifica data nel passato
            try {
                eventoTest.setData("2020-01-01");
            } catch (IllegalArgumentException e) {
                System.out.println("Errore setter data passata: " + e.getMessage());
            }
            
            // Test modifica data formato non valido
            try {
                eventoTest.setData("15/11/2025");
            } catch (IllegalArgumentException e) {
                System.out.println("Errore setter formato data: " + e.getMessage());
            }
            
        } catch (IllegalArgumentException e) {
             System.err.println("Errore nella creazione dell'evento test: " + e.getMessage());
         }
         
         // Test validazioni metodo prenota
         System.out.println("\n--- Test validazioni prenota ---");
         try {
             Evento eventoTest = new Evento("Evento Piccolo", "2025-12-31", 2);
             System.out.println("Evento creato: " + eventoTest);
             
             // Test prenotazione normale
             eventoTest.prenota();
             System.out.println("Prima prenotazione: " + eventoTest);
             
             eventoTest.prenota();
             System.out.println("Seconda prenotazione: " + eventoTest);
             
             // Test prenotazione quando non ci sono più posti
             try {
                 eventoTest.prenota();
             } catch (IllegalArgumentException e) {
                 System.out.println("Errore posti esauriti: " + e.getMessage());
             }
             
             // Test prenotazione per evento passato
             try {
                 Evento eventoPassato = new Evento("Evento Passato Test", "2020-01-01", 100);
             } catch (IllegalArgumentException e) {
                 // Questo evento non può essere creato, quindi testiamo modificando la data
                 System.out.println("Test evento passato: creazione evento passato già bloccata dal costruttore");
             }
             
         } catch (IllegalArgumentException e) {
             System.err.println("Errore nei test prenota: " + e.getMessage());
         }
         
         // Test validazioni metodo disdici
         System.out.println("\n--- Test validazioni disdici ---");
         try {
             Evento eventoTest = new Evento("Evento Test Disdici", "2025-12-31", 5);
             System.out.println("Evento creato: " + eventoTest);
             
             // Prima facciamo alcune prenotazioni
             eventoTest.prenota();
             eventoTest.prenota();
             eventoTest.prenota();
             System.out.println("Dopo 3 prenotazioni: " + eventoTest);
             
             // Test disdetta normale
             eventoTest.disdici();
             System.out.println("Dopo prima disdetta: " + eventoTest);
             
             eventoTest.disdici();
             System.out.println("Dopo seconda disdetta: " + eventoTest);
             
             eventoTest.disdici();
             System.out.println("Dopo terza disdetta: " + eventoTest);
             
             // Test disdetta quando non ci sono prenotazioni
             try {
                 eventoTest.disdici();
             } catch (IllegalArgumentException e) {
                 System.out.println("Errore nessuna prenotazione da disdire: " + e.getMessage());
             }
             
             // Test disdetta per evento passato
             // Non possiamo creare un evento passato, quindi testiamo il comportamento
             System.out.println("Test disdetta evento passato: non testabile direttamente perché il costruttore impedisce la creazione di eventi passati");
             
         } catch (IllegalArgumentException e) {
             System.err.println("Errore nei test disdici: " + e.getMessage());
         }
     }
 }