// Superklasse Legemiddel (abstrakt, kan ikke instansieres)
abstract class Legemiddel {
    private static int idTeller = 0; // Statisk teller for å gi unike ID-er
    public final String navn;
    public final int id;
    public int pris;
    public final double mengdeVirkestoff;

    public Legemiddel(String navn, int pris, double mengdeVirkestoff) {
        this.navn = navn;
        this.id = idTeller++;
        this.pris = pris;
        this.mengdeVirkestoff = mengdeVirkestoff;
    }

    public int hentPris() {
        return pris;
    }

    public void settNyPris(int pris) {
        this.pris = pris;
    }

    @Override
    public String toString() {
        return "Legemiddel: " + navn + " (ID: " + id + "), Pris: " + pris + " kr, Virkestoff: " + mengdeVirkestoff + " mg";
    }
}

// Subklasse Narkotisk
class Narkotisk extends Legemiddel {
    public final int styrke;

    public Narkotisk(String navn, int pris, double mengdeVirkestoff, int styrke) {
        super(navn, pris, mengdeVirkestoff);
        this.styrke = styrke;
    }

    @Override
    public String toString() {
        return super.toString() + ", Narkotisk styrke: " + styrke;
    }
}

// Subklasse Vanedannende
class Vanedannende extends Legemiddel {
    public final int styrke;

    public Vanedannende(String navn, int pris, double mengdeVirkestoff, int styrke) {
        super(navn, pris, mengdeVirkestoff);
        this.styrke = styrke;
    }

    @Override
    public String toString() {
        return super.toString() + ", Vanedannende styrke: " + styrke;
    }
}

// Subklasse Vanlig
class Vanlig extends Legemiddel {
    public Vanlig(String navn, int pris, double mengdeVirkestoff) {
        super(navn, pris, mengdeVirkestoff);
    }
}

// Testprogram for Legemidler
class TestLegemiddel {
    public static void main(String[] args) {
        Narkotisk narko = new Narkotisk("Morfin", 500, 10.5, 8);
        Vanedannende vane = new Vanedannende("Valium", 300, 5.0, 5);
        Vanlig vanlig = new Vanlig("Paracet", 50, 1.0);
        
        // Tester
        System.out.println(narko);
        System.out.println(vane);
        System.out.println(vanlig);
        
        // Test for ID-er
        System.out.println("Test ID-er:");
        System.out.println(narko.id == 0 ? "OK" : "FEIL");
        System.out.println(vane.id == 1 ? "OK" : "FEIL");
        System.out.println(vanlig.id == 2 ? "OK" : "FEIL");
    }
}
