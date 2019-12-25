package com.java.samples.annotations.printing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) {
		Printer<ColorCartridge> printer = new Printer<ColorCartridge>(new ColorCartridge());

		PrintingDevice annotation = printer.getClass().getAnnotation(PrintingDevice.class);

		try {

			Method printMethod = printer.getClass().getMethod(annotation.defaultPrintMethod(), int.class);
			printMethod.invoke(printer, annotation.defaultNumberOfCopies());

		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
