public class Main {
    public static void main(String[] args) {
        // Creazione di alcuni eventi di esempio
        Evento concerto = new Evento("Concerto di Rock", "2024-06-15", 5000);
        Evento conferenza = new Evento("Conferenza sulla Tecnologia", "2024-07-20", 200);
        Evento spettacolo = new Evento("Spettacolo Teatrale", "2024-08-10", 300);
        
        // Stampa degli eventi
        System.out.println(concerto);
        System.out.println(conferenza);
        System.out.println(spettacolo);
        
        // Test dei metodi getter e setter
        System.out.println("\nTitolo del primo evento: " + concerto.getTitolo());
        System.out.println("Data del primo evento: " + concerto.getData());
        System.out.println("Posti totali del primo evento: " + concerto.getPostiTotali());
        
        // Modifica del titolo, data e posti totali
        concerto.setTitolo("Concerto di Jazz");
        concerto.setData("2024-06-22");
        concerto.setPostiTotali(4500);
        System.out.println("Evento modificato: " + concerto);
    }
}