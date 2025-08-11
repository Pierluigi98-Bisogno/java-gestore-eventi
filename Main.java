import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Richiesta dati evento all'utente
            System.out.println("=== CREAZIONE NUOVO EVENTO ===");
            System.out.print("Inserisci il titolo dell'evento: ");
            String titolo = scanner.nextLine();
            
            System.out.print("Inserisci la data dell'evento (formato yyyy-MM-dd): ");
            String data = scanner.nextLine();
            
            System.out.print("Inserisci il numero di posti totali: ");
            int postiTotali = scanner.nextInt();
            
            // Creazione evento
            Evento evento = new Evento(titolo, data, postiTotali);
            System.out.println("\nEvento creato con successo: " + evento);
            
            // Gestione prenotazioni
            System.out.println("\n=== GESTIONE PRENOTAZIONI ===");
            System.out.print("Vuoi effettuare delle prenotazioni? (s/n): ");
            scanner.nextLine(); // Consuma il newline rimasto
            String risposta = scanner.nextLine().toLowerCase();
            
            if (risposta.equals("s") || risposta.equals("si")) {
                System.out.print("Quante prenotazioni vuoi effettuare? ");
                int numPrenotazioni = scanner.nextInt();
                
                // Effettua le prenotazioni
                int prenotazioniEffettuate = 0;
                for (int i = 0; i < numPrenotazioni; i++) {
                    try {
                        evento.prenota();
                        prenotazioniEffettuate++;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Errore nella prenotazione " + (i + 1) + ": " + e.getMessage());
                        break;
                    }
                }
                
                System.out.println("Prenotazioni effettuate: " + prenotazioniEffettuate);
            }
            
            // Stampa stato attuale
            System.out.println("\n=== STATO ATTUALE EVENTO ===");
            System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
            System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
            System.out.println("Evento: " + evento);
            
            // Gestione disdette
            System.out.println("\n=== GESTIONE DISDETTE ===");
            System.out.print("Vuoi effettuare delle disdette? (s/n): ");
            scanner.nextLine(); // Consuma il newline rimasto
            risposta = scanner.nextLine().toLowerCase();
            
            if (risposta.equals("s") || risposta.equals("si")) {
                System.out.print("Quante disdette vuoi effettuare? ");
                int numDisdette = scanner.nextInt();
                
                // Effettua le disdette
                int disdetteEffettuate = 0;
                for (int i = 0; i < numDisdette; i++) {
                    try {
                        evento.disdici();
                        disdetteEffettuate++;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Errore nella disdetta " + (i + 1) + ": " + e.getMessage());
                        break;
                    }
                }
                
                System.out.println("Disdette effettuate: " + disdetteEffettuate);
            }
            
            // Stampa stato finale
            System.out.println("\n=== STATO FINALE EVENTO ===");
            System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
            System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
            System.out.println("Evento: " + evento);
            
        } catch (IllegalArgumentException e) {
            System.err.println("Errore nella creazione dell'evento: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Errore imprevisto: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}