abstract class Resept {
    private static int idTeller = 0;
    private final int id;
    protected Legemiddel legemiddel;
    protected Lege utskrivendeLege;
    protected int pasientId;
    protected int reit;

    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        this.id = idTeller++;
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;
    }

    public int hentId() { return id; }
    public Legemiddel hentLegemiddel() { return legemiddel; }
    public Lege hentLege() { return utskrivendeLege; }
    public int hentPasientId() { return pasientId; }
    public int hentReit() { return reit; }

    public boolean bruk() {
        if (reit > 0) {
            reit--;
            return true;
        }
        return false;
    }

    public abstract String farge();
    public abstract int prisÅBetale();

    @Override
    public String toString() {
        return "Resept ID: " + id + ", Legemiddel: " + legemiddel.hentNavn() + 
               ", Lege: " + utskrivendeLege.hentNavn() + ", Pasient ID: " + pasientId +
               ", Reit: " + reit + ", Farge: " + farge() + ", Pris å betale: " + prisÅBetale() + " kr";
    }
}

class HvitResept extends Resept {
    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }
    public String farge() { return "Hvit"; }
    public int prisÅBetale() { return legemiddel.hentPris(); }
}

class MilitaerResept extends HvitResept {
    public MilitaerResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId) {
        super(legemiddel, utskrivendeLege, pasientId, 3);
    }
    public int prisÅBetale() { return 0; }
}

class PResept extends HvitResept {
    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }
    public int prisÅBetale() {
        return Math.max(0, legemiddel.hentPris() - 108);
    }
}

class BlaaResept extends Resept {
    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }
    public String farge() { return "Blå"; }
    public int prisÅBetale() { return (int) Math.round(legemiddel.hentPris() * 0.25); }
}