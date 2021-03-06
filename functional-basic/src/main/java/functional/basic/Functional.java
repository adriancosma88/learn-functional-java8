package functional.basic;

public class Functional {
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				System.out.println("from thread");
			}
		});

		thread.start();
		
		Runnable r = () -> System.out.println("from new thread");
		Thread t2 = new Thread(r);
		t2.start();
		
		System.out.println("in main");
	}
}

class Person {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(int age) {
		super();
		this.age = age;
	}
}
