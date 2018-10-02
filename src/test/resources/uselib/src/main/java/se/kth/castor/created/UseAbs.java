package se.kth.castor.created;

import se.kth.castor.types.Abs;
import se.kth.castor.types.ImplAbs;
import se.kth.castor.types.ImplInter;
import se.kth.castor.types.Inter;

public class UseAbs extends Abs {
	public UseAbs() {
		super();
	}
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
