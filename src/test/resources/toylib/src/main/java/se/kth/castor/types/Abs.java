package se.kth.castor.types;

public abstract class Abs {


	public String defString() {
		return "publicString";
	}
	public abstract String absString();


	public Abs defAbs() {
		return new ImplAbs();
	}
	public abstract Abs absAbs();



	public Inter defInter() {
		return new ImplInter();
	}
	public abstract Inter absInter();


	public ImplInter defImplInter() {
		return new ImplInter();
	}
	public abstract ImplInter absImplInter();
}
