import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

interface PredicateEx{
	public boolean test(String s);
}

class PredicateImpl implements PredicateEx{

	@Override
	public boolean test(String s) {
		return s.equals("sand");
	}
	
}

class parac{
	public static void main(String[] args) {
		PredicateEx ex = new PredicateImpl();
		System.out.println(ex.test("sand"));
	}
}

// instead of this whole thing
public class Prac {
	public static void main(String[] args) {
		Predicate<String> p = s -> s.equals("sand");			//Interface i = new implClass();
		System.out.println(p.test("sand"));
	}
}

interface INT {
	public String test(int i, String s);
}

class LambdaWithFunctionalInterface{
	public static void main(String[] args) {
		INT i = (in,s) -> {
			for(int l=0; l<=in; l++) {
				return s;
			}
			return s;
		};
		
		//or
		
		//INT i = new implClassforINT();
		System.out.println(i.test(3, "sandeep"));
	}
}


class LambdaWithInbuiltFunctionalInterface {
	public static void main(String[] args) {
		Predicate<String> p = s -> s.length() == 5;
		System.out.println(p.test("sandy"));
	}
}

class Employee {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	Employee(int id, String name){
		this.id = id;
		this.name = name;
	}
	public String toString() {
		return this.name;
	}
}

class LambdaWithInbuiltFunctionalInterface2 {
	public static void main(String[] args) {
		Function<String, Integer> f = s -> s.length();
		System.out.println(f.apply("Chandu"));
		Function<Employee, String> e = emp -> emp.getName();
		System.out.println(e.apply(new Employee(123, "muneer")));
		Function<List<Employee>, Integer> d = list -> {
			Employee emp = list.get(0);
			return emp.getId();
		};
		List<Employee> emp = new ArrayList<Employee>();
		Employee e1 = new Employee(111, "srinivas");
		Employee e2 = new Employee(222, "suraj");
		emp.add(e1);
		emp.add(e2);
		System.out.println(d.apply(emp));
		
	}
}

class LambdaWithInbuiltFunctionalInterface3 {
	public static void main(String[] args) {
		Consumer<String> c = s -> System.out.println(s);
		c.accept("sandeep!!!");
		Comparator c2 = new Comparator()
				{
				public int compare(Object obj1, Object obj2){
					return 1;
				}
				};
				
		List<Employee> list = new ArrayList<Employee>();
		list.sort(c2);
				
		
	}
}

class LambdaWithAllInbuiltFunctionalInterfaces {
	//login
	public static void main(String[] args) {
		Predicate<String> p = s -> s.equals("SandeepSee");
		if(p.test("SandeepSee")) {
			//book ticket
			Function<Employee, Boolean> f = e -> {
				Boolean bookingSuccessOrFailure = false;
				
				Predicate<Employee> p1 = e1 -> e1.getId() != 0 && e1.getName() != null;
				
				Consumer<Employee> c = emp -> {
					System.out.println("Ticket booked on name:"+emp.getName()+" with id:"+emp.getId());
				};
				
				if(p1.test(e)) {
					bookingSuccessOrFailure = true;
					c.accept(e);
				} else {
					bookingSuccessOrFailure = false;
				}
				return bookingSuccessOrFailure;
			};
			f.apply(new Employee(333, "Pullaginti"));
		
		}
		
	}	
}



class LambdaWithBiPredicateFI {
	
	public static void main(String[] args) {
		BiPredicate<String, String> b = (s1, s2) -> {
			return s1.length() == s2.length();
		};
		
		System.out.println(b.test("muneer", "karan"));
	}
}

class LambdaWithBiFunctionFI {
	
	public static void main(String[] args) {
		BiFunction<Employee, String, Integer> b = (e, s) ->{
			int id = 0;
			if(e.getName().equals(s)) {
				id = e.getId();
			}
			return id;
		};
		
		System.out.println(b.apply(new Employee(133, "mujeeb"), "mujeeb"));
		
	}
}

class LambdaWithBiConsumerFI {
	public static void main(String[] args) {
		BiConsumer<String, Integer> b = (s, i) -> {
			System.out.println(s+i);
		};
		b.accept("sand", 2);
	}
}


class LambdaWithSupplierFI {
	public static void main(String[] args) {
		Supplier<String> p = () -> {
			String s= "";
			for(int i=0; i<=6; i++) {
				s = s+ (int)(Math.random()*10);
			}
				return s;
		};
		System.out.println(p.get());
	}
}

class LambdaWithBiPredicateChaining {
	public static void main(String[] args) {
		BiPredicate<String, String> b1 = (s1, s2) -> s1.equals(s2);
		BiPredicate<String, String> b2 = (i1, i2) -> i1 == i2;
		
		System.out.println(b1.and(b2).test(new String("sand"), new String("sand")));
		System.out.println(b1.or(b2).test(new String("sand"), new String("sand")));
	}
}

/*class LambdaWithBiFunctionChaining {
	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> b1= (i1, i2) -> i1*i1;
		BiFunction<Integer, Integer, Integer> b2= (i1, i2) -> i1*i1*i1;
		
		System.out.println(b1.andThen(b2).apply());
	}
}*/

class LambdaWithFunctionChaining {
	public static void main(String[] args) {
		Function<Integer, Integer> b1= (i1) -> i1*i1;
		Function<Integer, Integer> b2= (i1) -> i1*i1*i1;
		
		System.out.println(b1.andThen(b2).apply(2));
		System.out.println(b1.compose(b2).apply(2));
	}
}

class LambdaWithConsumerChaining {
	public static void main(String[] args) {
		Consumer<String> c1 = s -> System.out.println(s+"first");
		Consumer<String> c2 = s -> System.out.println(s+"second");
		c1.andThen(c2).accept("sand");
	}
}


/*For chaining,
Predicate -> and, or
Function -> andThen, compose
Consumer -> andThen
Supplier -> ----*/


class Timepass {
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(123, "sandeep"));
		list.add(new Employee(566, "muneer"));
		list.add(new Employee(655, "seenu"));
		list.sort(new Comparator<Employee>() 
		{
			public int compare(Employee e1, Employee e2){
				
				return e1.getName().compareTo(e2.getName());
			}
		}
		);
		System.out.println(list);
		
	}
}


class OtherBuiltinFI {
	public static void main(String[] args) {
		UnaryOperator<Integer>  uo= i -> i*i;
		IntUnaryOperator uo1 = j -> j*j*j;
		System.out.println(uo1.applyAsInt(3));
		System.out.println(uo.apply(3));
		
	}
}




// Constructor and method reference instead of Lambda Expressions


class methodRefFIPredicate{
	public static boolean check(String s) {
		return s.length() == 7;
	}
	
	public static void main(String[] args) {
		Predicate<String> p = methodRefFIPredicate::check;
		System.out.println(p.test("sandeep"));
		
	}
}

class MethodRefFIFunction{
	public String check(String s) {
		return s.substring(0, 3);
	}
	
	public static void main(String[] args) {
		MethodRefFIFunction methodRefFIFunction = new MethodRefFIFunction();
		Function<String, String> f = methodRefFIFunction::check;
		System.out.println(f.apply("Sandeep"));
		
	}
}

class ConstructorRefFIFunction{
	
	public static void main(String[] args) {
		BiFunction<Integer, String, Employee> f = Employee::new;
		System.out.println(f.apply(128, "Rohit"));
		
	}
}



class MethodReferenceCheck {
	public void method1(String str) {
		System.out.println("method1 "+str);
	}
}

class FICheckingMethodReference {
	public static void main(String[] args) {
		MethodReferenceCheck ref = new MethodReferenceCheck();
		Consumer<String> c = ref::method1;
		c.accept("sandeep");
	}
}

class MethodReferenceStaticCheck {
	public static int method2(int i1, int i2) {
		return i1*i2;
	}
}

class FICheckingMethodReferenceStatic {
	public static void main(String[] args) {
		//System.out.println(MethodReferenceStaticCheck.method2(10, 20));
		BiFunction<Integer, Integer, Integer> biFunction = MethodReferenceStaticCheck::method2;
		System.out.println(biFunction.apply(10, 30));
	}
}

class Student {
	private String name;
	private int marks;
	
	public Student(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
		System.out.println(this.name+this.marks);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String toString() {
		return this.name+" "+this.marks;
	}
	
}

class MRWithNEW {
	public static void main(String[] args) {
		BiFunction<String, Integer, Student> function = Student::new;
		System.out.println(function.apply("sandeep", 90));
		
	}
}
