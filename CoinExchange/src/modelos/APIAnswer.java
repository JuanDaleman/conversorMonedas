package modelos;
import modelos.APIAnswerOmdb;

public class APIAnswer implements Comparable <APIAnswer> {
    private String actualCurrency;
    private String targetCurrency;
    private double result;
    private double mountToConvert;

    public APIAnswer(APIAnswerOmdb apiAnswerOmdb) {
        this.actualCurrency = apiAnswerOmdb.base_code();
        this.targetCurrency = apiAnswerOmdb.target_code();
        this.result = apiAnswerOmdb.conversion_result();
        this.mountToConvert = Math.round((float)apiAnswerOmdb.conversion_result() / apiAnswerOmdb.conversion_rate());
    }

    public String getActualCurrency() {
        return actualCurrency;
    }

    public void setActualCurrency(String actualCurrency) {
        this.actualCurrency = actualCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public double getMountToConvert() {
        return mountToConvert;
    }

    public void setMountToConvert(double mountToConvert) {
        this.mountToConvert = mountToConvert;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result){
        this.result = result;
    }

    @Override
    public int compareTo(APIAnswer o) {
        return 0;
    }

    @Override
    public String toString() {
        return "El valor de " + mountToConvert + " " + actualCurrency  +
                " corresponde a " + result +" "+ targetCurrency;
    }
}
