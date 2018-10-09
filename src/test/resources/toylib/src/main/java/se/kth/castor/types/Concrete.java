package se.kth.castor.types;

public class Concrete {
    public Concrete() {
    }

    protected Concrete(String param1) {
    }

    private Concrete(String param1, String param2) {
    }


    public String publicString() {
        return "publicString";
    }

    protected String protectedString() {
        return "protectedString";
    }

    private String privateString() {
        return "privateString";
    }


    public Abs publicAbs() {
        return new ImplAbs();
    }

    protected Abs protectedAbs() {
        return new ImplAbs();
    }

    private Abs privateAbs() {
        return new ImplAbs();
    }


    public Inter publicInter() {
        return new ImplInter();
    }

    protected Inter protectedInter() {
        return new ImplInter();
    }

    private Inter privateInter() {
        return new ImplInter();
    }


    public ImplInter publicImplInter() {
        return new ImplInter();
    }

    protected ImplInter protectedImplInter() {
        return new ImplInter();
    }

    private ImplInter privateImplInter() {
        return new ImplInter();
    }
}
