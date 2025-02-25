public class TestResepter {
    public static void main(String[] args) {
        // Oppretter noen testobjekter av Legemiddel og Lege
        Legemiddel legemiddel1 = new Legemiddel("Paracet", 100, 500);
        Legemiddel legemiddel2 = new Legemiddel("Ibux", 200, 600);
        Lege lege1 = new Lege("Dr. Hansen");
        Lege lege2 = new Lege("Dr. Berg");

        // Oppretter resepter av forskjellige typer
        HvitResept hvitResept = new HvitResept(legemiddel1, lege1, 123, 5);
        MilitaerResept militaerResept = new MilitaerResept(legemiddel2, lege1, 456);
        PResept pResept = new PResept(legemiddel1, lege2, 789, 3);
        BlaaResept blaaResept = new BlaaResept(legemiddel2, lege2, 101, 4);

        // Tester metoder
        System.out.println("Hvit Resept: " + hvitResept);
        System.out.println("Militær Resept: " + militaerResept);
        System.out.println("P-Resept: " + pResept);
        System.out.println("Blå Resept: " + blaaResept);

        // Tester bruk()-metoden
        System.out.println("Bruker hvit resept: " + hvitResept.bruk());
        System.out.println("Antall gjenværende: " + hvitResept.hentReit());
        
        System.out.println("Bruker militær resept: " + militaerResept.bruk());
        System.out.println("Antall gjenværende: " + militaerResept.hentReit());
        
        System.out.println("Bruker P-resept: " + pResept.bruk());
        System.out.println("Antall gjenværende: " + pResept.hentReit());
        
        System.out.println("Bruker blå resept: " + blaaResept.bruk());
        System.out.println("Antall gjenværende: " + blaaResept.hentReit());

        // Tester prisÅBetale-metoden
        System.out.println("Pris for hvit resept: " + hvitResept.prisÅBetale());
        System.out.println("Pris for militær resept: " + militaerResept.prisÅBetale());
        System.out.println("Pris for P-resept: " + pResept.prisÅBetale());
        System.out.println("Pris for blå resept: " + blaaResept.prisÅBetale());
    }
}
