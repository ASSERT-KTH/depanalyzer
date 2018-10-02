package se.kth.castor.types;

public class ImplInter implements Inter {
	@Override
	public String getString() {
		return "String";
	}

	@Override
	public Inter getInter() {
		return new ImplInter();
	}

	@Override
	public Abs getAbs() {
		return new ImplAbs();
	}

	@Override
	public Concrete getConcrete() {
		return new Concrete();
	}
}
