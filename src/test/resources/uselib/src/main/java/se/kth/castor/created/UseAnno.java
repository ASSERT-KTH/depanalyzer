package se.kth.castor.created;

import se.kth.castor.types.Anno;

@Anno
public class UseAnno {
	public String method() {
		return UseAnno.class.getAnnotation(Anno.class).getString();
	}
}
