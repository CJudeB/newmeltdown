package objects;

public class Situation {
    private String name;
    private String describe;

    public Situation(String vName, String vDescribe) {
        this.name = vName;
        this.describe = vDescribe;
    }

    public String getName() {
        return name;
    }

    public void setName(String vName) {
        this.name = vName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String vDescribe) {
        this.describe = vDescribe;
    }


}








