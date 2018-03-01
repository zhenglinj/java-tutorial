package com.z.java.samples.annotations.printing;

@PrintingDevice(defaultPrintMethod = "print", defaultNumberOfCopies = 5)
public class Printer<T extends ICartridge> implements IMachine {
	private T cartridge;

	public Printer(T cartridge) {
		this.cartridge = cartridge;
	}

	@Override
	public void turnOn() {
		System.out.println("Turn on");
	}

	@Override
	public void turnOff() {
		System.out.println("Turn off");
	}

	public void print(int copies) {
		System.out.println("Cartridge: " + cartridge + ", Copies number: " + copies);
	}
}
