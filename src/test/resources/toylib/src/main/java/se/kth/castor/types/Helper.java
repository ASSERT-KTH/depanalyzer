package se.kth.castor.types;

public class Helper {
	private Helper() {}


	static public String publicString() {
		return "publicString";
	}

	static protected String protectedString() {
		return "protectedString";
	}

	static private String privateString() {
		return "privateString";
	}


	static public Abs publicAbs() {
		return new ImplAbs();
	}

	static protected Abs protectedAbs() {
		return new ImplAbs();
	}

	static private Abs privateAbs() {
		return new ImplAbs();
	}


	static public ImplAbs publicImplAbs() {
		return new ImplAbs();
	}

	static protected ImplAbs protectedImplAbs() {
		return new ImplAbs();
	}

	static private ImplAbs privateImplAbs() {
		return new ImplAbs();
	}


	static public Inter publicInter() {
		return new ImplInter();
	}

	static protected Inter protectedInter() {
		return new ImplInter();
	}

	static private Inter privateInter() {
		return new ImplInter();
	}


	static public ImplInter publicImplInter() {
		return new ImplInter();
	}

	static protected ImplInter protectedImplInter() {
		return new ImplInter();
	}

	static private ImplInter privateImplInter() {
		return new ImplInter();
	}





	static public String myPublicString = "publicString";

	static protected String myProtectedString = "protectedString";

	static private String myPrivateString = "privateString";


	static public Abs myPublicAbs = new ImplAbs();

	static protected Abs myProtectedAbs = new ImplAbs();

	static private Abs myPrivateAbs = new ImplAbs();


	static public ImplAbs myPublicImplAbs = new ImplAbs();

	static protected ImplAbs myProtectedImplAbs = new ImplAbs();

	static private ImplAbs myPrivateImplAbs = new ImplAbs();


	static public Inter myPublicInter = new ImplInter();

	static protected Inter myProtectedInter = new ImplInter();

	static private Inter myPrivateInter = new ImplInter();


	static public ImplInter myPublicImplInter = new ImplInter();

	static protected ImplInter myProtectedImplInter = new ImplInter();

	static private ImplInter myPrivateImplInter = new ImplInter();
}
