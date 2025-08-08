public class Main {
    public static void main(String[] args) {
        // Creazione di alcuni eventi di esempio
        Evento concerto = new Evento("Concerto di Rock", "2024-06-15", 5000, 3500);
        Evento conferenza = new Evento("Conferenza sulla Tecnologia", "2024-07-20", 200, 150);
        Evento spettacolo = new Evento("Spettacolo Teatrale", "2024-08-10", 300, 280);
        
        // Stampa degli eventi
        System.out.println(concerto);
        System.out.println(conferenza);
        System.out.println(spettacolo);
        
        // Test dei metodi getter e setter
        System.out.println("\nTitolo del primo evento: " + concerto.getTitolo());
        System.out.println("Data del primo evento: " + concerto.getData());
        System.out.println("Posti totali del primo evento: " + concerto.getPostiTotali());
        System.out.println("Posti prenotati del primo evento: " + concerto.getPostiPrenotati());
        
        // Modifica del titolo, data, posti totali e prenotati
        concerto.setTitolo("Concerto di Jazz");
        concerto.setData("2024-06-22");
        concerto.setPostiTotali(4500);
        concerto.setPostiPrenotati(3200);
        System.out.println("Evento modificato: " + concerto);
    }
}