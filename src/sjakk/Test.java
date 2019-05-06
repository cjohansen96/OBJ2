package sjakk;

public class Test {
    public static void main(String[] args) {
        Manager m = new Manager();
        Spiller spiller1 = new Spiller("Chris");
        Spiller spiller2 = new Spiller("Jon");
        m.leggTilParti(spiller1, spiller2, "23-12-09", "13:37", "SVART", "Ba4 Bf6");
        
        Spiller spiller3 = new Spiller("Markus");
        Spiller spiller4 = new Spiller("Geir");
        m.leggTilParti(spiller3, spiller4, "23-12-09", "13:37", "HVIT", "Fg6");
        
        System.out.println(m.getPartierUtTekst());
    }
}
