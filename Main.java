// Importiamo Scanner per leggere l'input dell'utente dalla tastiera
import java.util.Scanner;

/**
 * Classe Main - il punto di ingresso del nostro programma
 * Questa classe crea un'interfaccia utente per gestire eventi
 */
public class Main {
    /**
     * Metodo main - viene eseguito quando avviamo il programma
     * @param args - argomenti da riga di comando (non li usiamo)
     */
    public static void main(String[] args) {
        // Scanner ci permette di leggere quello che l'utente scrive
        Scanner scanner = new Scanner(System.in);
        
        // try-catch ci permette di gestire gli errori che potrebbero verificarsi
        try {
            // FASE 1: RACCOLTA DATI PER CREARE L'EVENTO
            System.out.println("=== CREAZIONE NUOVO EVENTO ===");
            
            // Chiediamo all'utente di inserire il titolo
            System.out.print("Inserisci il titolo dell'evento: ");
            String titolo = scanner.nextLine();  // nextLine() legge tutta la riga
            
            // Chiediamo la data nel formato specifico
            System.out.print("Inserisci la data dell'evento (formato yyyy-MM-dd): ");
            String data = scanner.nextLine();
            
            // Chiediamo il numero di posti totali
            System.out.print("Inserisci il numero di posti totali: ");
            int postiTotali = scanner.nextInt();  // nextInt() legge solo il numero
            
            // FASE 2: CREAZIONE DELL'EVENTO
            // Qui creiamo un nuovo oggetto Evento con i dati inseriti
            // Se ci sono errori (data nel passato, posti negativi), il costruttore lancerà un'eccezione
            Evento evento = new Evento(titolo, data, postiTotali);
            System.out.println("\nEvento creato con successo: " + evento);
            
            // FASE 3: GESTIONE DELLE PRENOTAZIONI
            System.out.println("\n=== GESTIONE PRENOTAZIONI ===");
            System.out.print("Vuoi effettuare delle prenotazioni? (s/n): ");
            
            // IMPORTANTE: dopo nextInt() rimane un "\n" nel buffer, quindi lo consumiamo
            scanner.nextLine(); // Questo "pulisce" il buffer
            String risposta = scanner.nextLine().toLowerCase(); // toLowerCase() converte in minuscolo
            
            // Controlliamo se l'utente vuole fare prenotazioni
            if (risposta.equals("s") || risposta.equals("si")) {
                System.out.print("Quante prenotazioni vuoi effettuare? ");
                int numPrenotazioni = scanner.nextInt();
                
                // Proviamo a fare le prenotazioni una per una
                int prenotazioniEffettuate = 0;  // Contatore per tenere traccia di quelle riuscite
                
                // Ciclo for: ripete l'operazione per il numero di prenotazioni richieste
                for (int i = 0; i < numPrenotazioni; i++) {
                    try {
                        evento.prenota();  // Proviamo a prenotare un posto
                        prenotazioniEffettuate++;  // Se ci riusciamo, aumentiamo il contatore
                    } catch (IllegalArgumentException e) {
                        // Se c'è un errore (es: posti finiti), lo stampiamo e usciamo dal ciclo
                        System.out.println("Errore nella prenotazione " + (i + 1) + ": " + e.getMessage());
                        break;  // break esce dal ciclo for
                    }
                }
                
                System.out.println("Prenotazioni effettuate: " + prenotazioniEffettuate);
            }
            
            // FASE 4: MOSTRIAMO LO STATO ATTUALE DELL'EVENTO
            System.out.println("\n=== STATO ATTUALE EVENTO ===");
            System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
            
            // Calcoliamo i posti disponibili sottraendo i prenotati dai totali
            int postiDisponibili = evento.getPostiTotali() - evento.getPostiPrenotati();
            System.out.println("Posti disponibili: " + postiDisponibili);
            
            // toString() dell'evento mostra "data - titolo"
            System.out.println("Evento: " + evento);
            
            // FASE 5: GESTIONE DELLE DISDETTE (CANCELLAZIONI)
            System.out.println("\n=== GESTIONE DISDETTE ===");
            System.out.print("Vuoi effettuare delle disdette? (s/n): ");
            
            // Di nuovo, puliamo il buffer dopo aver usato nextInt()
            scanner.nextLine();
            risposta = scanner.nextLine().toLowerCase();
            
            // Controlliamo se l'utente vuole fare disdette
            if (risposta.equals("s") || risposta.equals("si")) {
                System.out.print("Quante disdette vuoi effettuare? ");
                int numDisdette = scanner.nextInt();
                
                // Proviamo a fare le disdette una per una
                int disdetteEffettuate = 0;  // Contatore per quelle riuscite
                
                // Ciclo for per le disdette
                for (int i = 0; i < numDisdette; i++) {
                    try {
                        evento.disdici();  // Proviamo a disdire una prenotazione
                        disdetteEffettuate++;  // Se ci riusciamo, aumentiamo il contatore
                    } catch (IllegalArgumentException e) {
                        // Se c'è un errore (es: nessuna prenotazione da disdire), lo stampiamo
                        System.out.println("Errore nella disdetta " + (i + 1) + ": " + e.getMessage());
                        break;  // Usciamo dal ciclo
                    }
                }
                
                System.out.println("Disdette effettuate: " + disdetteEffettuate);
            }
            
            // FASE 6: MOSTRIAMO LO STATO FINALE DELL'EVENTO
            System.out.println("\n=== STATO FINALE EVENTO ===");
            System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
            
            // Ricalcoliamo i posti disponibili dopo le eventuali disdette
            int postiFinaliDisponibili = evento.getPostiTotali() - evento.getPostiPrenotati();
            System.out.println("Posti disponibili: " + postiFinaliDisponibili);
            
            System.out.println("Evento: " + evento);
            
        // GESTIONE DEGLI ERRORI
        } catch (IllegalArgumentException e) {
            // Questo tipo di errore viene lanciato quando i dati inseriti non sono validi
            // (es: data nel passato, posti negativi, formato data sbagliato)
            System.err.println("Errore nella creazione dell'evento: " + e.getMessage());
        } catch (Exception e) {
            // Questo cattura qualsiasi altro tipo di errore imprevisto
            System.err.println("Errore imprevisto: " + e.getMessage());
        } finally {
            // finally viene SEMPRE eseguito, anche se ci sono errori
            // È importante chiudere lo Scanner per liberare le risorse
            scanner.close();
        }
    }
}