package com.zhenglinj.java.samples.annotations.printing;

public class ColorCartridge implements ICartridge {
	@Override
	public String toString() {
		return ColorCartridge.class.getName();
	}
}
