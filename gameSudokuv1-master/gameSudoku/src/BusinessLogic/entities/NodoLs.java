package BusinessLogic.entities;

public class NodoLs {
    private String INFO;
    private NodoLs LIGA;

    public NodoLs(String INFO, NodoLs LIGA) {
        this.INFO = INFO;
        this.LIGA = LIGA;
    }

    public NodoLs(String INFO) {
        this.INFO = INFO;
        this.LIGA = null;
    }

    public NodoLs() {
        super();
    }

    public NodoLs getLIGA() {
        return LIGA;
    }

    public void setLIGA(NodoLs lIGA) {
        LIGA = lIGA;
    }

    public String getINFO() {
        return INFO;
    }

    public void setINFO(String iNFO) {
        INFO = iNFO;
    }

}
