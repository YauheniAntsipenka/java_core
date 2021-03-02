package enums;

public enum Month {
    OCTOBER,
    NOVEMBER,
    DECEMBER
}

enum kekEnum{
    KEK1(1, "1"),
    KEK2(2, "2"),
    KEK3(3, "3")
    ;
    private int q;
    private String s;
    private kekEnum(int q1, String s1){
        this.q = q1;
        this.s = s1;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "kekEnum{" +
            "q=" + q +
            ", s='" + s + '\'' +
            '}';
    }
}
