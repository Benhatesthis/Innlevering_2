// Grensesnittet for godkjenningsfritak
interface Godkjenningsfritak {
    String hentKontrollkode();
}

// Lege-klassen
class Lege {
    protected String navn;

    public Lege(String navn) {
        this.navn = navn;
    }

    public String hentNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return "Lege: " + navn;
    }
}

// Spesialist-klassen som arver fra Lege og implementerer Godkjenningsfritak
class Spesialist extends Lege implements Godkjenningsfritak {
    private String kontrollkode;

    public Spesialist(String navn, String kontrollkode) {
        super(navn);
        this.kontrollkode = kontrollkode;
    }

    @Override
    public String hentKontrollkode() {
        return kontrollkode;
    }

    @Override
    public String toString() {
        return "Spesialist: " + navn + ", Kontrollkode: " + kontrollkode;
    }
}
