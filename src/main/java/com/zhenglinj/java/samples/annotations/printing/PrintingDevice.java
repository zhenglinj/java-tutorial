package com.zhenglinj.java.samples.annotations.printing;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PrintingDevice {
	String defaultPrintMethod();
	int defaultNumberOfCopies();
}
