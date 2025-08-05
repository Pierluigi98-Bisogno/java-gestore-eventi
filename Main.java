public class Main {
    public static void main(String[] args) {
        // Creazione di alcuni eventi di esempio
        Evento concerto = new Evento("Concerto di Rock");
        Evento conferenza = new Evento("Conferenza sulla Tecnologia");
        Evento spettacolo = new Evento("Spettacolo Teatrale");
        
        // Stampa degli eventi
        System.out.println(concerto);
        System.out.println(conferenza);
        System.out.println(spettacolo);
        
        // Test dei metodi getter e setter
        System.out.println("\nTitolo del primo evento: " + concerto.getTitolo());
        
        // Modifica del titolo
        concerto.setTitolo("Concerto di Jazz");
        System.out.println("Titolo modificato: " + concerto.getTitolo());
    }
}