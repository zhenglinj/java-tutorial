package com.zhenglinj.java.samples.basic;

public class FinalizeEscapeGC {
	public static FinalizeEscapeGC saveHook = null;

	public void isAlive() {
		System.out.println("yes, i am still alive");
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed");
		saveHook = this;
	}

	public static void main(String[] args) throws InterruptedException {
		saveHook = new FinalizeEscapeGC();
		saveHook = null;
		System.gc();
		// wait 1s that finalize() is low priority and managed by JVM
		Thread.sleep(1000);

		if (saveHook != null) {
			saveHook.isAlive();
		} else {
			System.out.println("no, i am dead");
		}

		// the codes are same with above
		saveHook = null;
		System.gc();
		Thread.sleep(1000);

		if (saveHook != null) {
			saveHook.isAlive();
		} else {
			System.out.println("no, i am dead");
		}
	}
}
