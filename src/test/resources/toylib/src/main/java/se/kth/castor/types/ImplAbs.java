package se.kth.castor.types;

public class ImplAbs extends Abs {
	@Override
	public String absString() {
		return "absString";
	}

	@Override
	public Abs absAbs() {
		return new ImplAbs();
	}

	@Override
	public Inter absInter() {
		return new ImplInter();
	}

	@Override
	public ImplInter absImplInter() {
		return new ImplInter();
	}
}
