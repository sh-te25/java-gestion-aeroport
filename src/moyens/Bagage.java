package moyens;

public class Bagage {
    private String idBagage;

    public Bagage(String idBagage) {
        this.idBagage = idBagage;
    }

    public String getIdBagage() {
        return idBagage;
    }

    @Override
    public String toString() {
        return "Bagage: " + idBagage;
    }
}
