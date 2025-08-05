public class Main {
    public static void main(String[] args) {
        // Creazione di alcuni eventi di esempio
        Evento concerto = new Evento("Concerto di Rock", "2024-06-15");
        Evento conferenza = new Evento("Conferenza sulla Tecnologia", "2024-07-20");
        Evento spettacolo = new Evento("Spettacolo Teatrale", "2024-08-10");
        
        // Stampa degli eventi
        System.out.println(concerto);
        System.out.println(conferenza);
        System.out.println(spettacolo);
        
        // Test dei metodi getter e setter
        System.out.println("\nTitolo del primo evento: " + concerto.getTitolo());
        System.out.println("Data del primo evento: " + concerto.getData());
        
        // Modifica del titolo e della data
        concerto.setTitolo("Concerto di Jazz");
        concerto.setData("2024-06-22");
        System.out.println("Evento modificato: " + concerto);
    }
}