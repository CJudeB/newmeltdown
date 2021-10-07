package objects;


public class Tile extends Definer{

    private int n, s, e, w;

    public Tile(String vName, String vDescribe, int vN, int vS, int vE, int vW) {
        super(vName, vDescribe); this.n = vN; this.s = vS; this.e = vE; this.w = vW;
    }
    public int getN() {
        return n;
    }
    public void setN(int vN) {
        this.n = vN;
    }

    public int getS() {
        return s;
    }
    public void setS(int vS) {
        this.s = vS;
    }

    public int getE() {
        return e;
    }
    public void setE(int vE) {
        this.e = vE;
    }

    public int getW() {
        return w;
    }
    public void setW(int vW) {
        this.w = vW;
    }
}
