import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Hello Peter");
		//ArrayListBasic();
		//ArrayListModivy();
		//ArrayToArrayList();
		//SearchSortArrayList();
		ArrayListCustomObject();
	}
	private static void ArrayListBasic() {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		System.out.println(list);

		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String str = iterator.next();
			System.out.println(str);
		}
		String item = list.get(1);
		System.out.printf("Item index 1: %s\n", item);

		for (String str : list) {
			System.out.println(str);
		}
	}
	
	private static void ArrayListModivy() {
		List<StringBuilder> lst = new ArrayList<StringBuilder>();
		lst.add(new StringBuilder("alpha"));
		lst.add(new StringBuilder("beta"));
		lst.add(new StringBuilder("charlie"));
		System.out.println(lst); // [alpha, beta, charlie]

		for (StringBuilder sb : lst) {
			sb.append("88"); // can modify "mutable" objects
		}
		System.out.println(lst); // [alpha88, beta88, charlie88]
	}

	private static void ArrayToArrayList() {
		String[] strs = { "alpha", "beta", "charlie" };
		System.out.println(Arrays.toString(strs)); // [alpha, beta, charlie]

		List<String> lst = Arrays.asList(strs);
		System.out.println(lst); // [alpha, beta, charlie]

		// Changes in array or list write thru
		strs[0] += "88";
		lst.set(2, lst.get(2) + "99");
		System.out.println(Arrays.toString(strs)); // [alpha88, beta, charlie99]
		System.out.println(lst); // [alpha88, beta, charlie99]

		// Initialize a list using an array
		List<Integer> lstInt = Arrays.asList(22, 44, 11, 33);
		System.out.println(lstInt); // [22, 44, 11, 33]
	}

	private static void SearchSortArrayList() {
		// Sort and search an "array" of Strings
		String[] array = { "Hello", "hello", "Hi", "HI" };

		// Use the Comparable defined in the String class
		Arrays.sort(array);
		System.out.println(Arrays.toString(array)); // [HI, Hello, Hi, hello]

		// Try binary search - the array must be sorted
		System.out.println(Arrays.binarySearch(array, "Hello")); // 1
		System.out.println(Arrays.binarySearch(array, "HELLO")); // -1 (insertion at index 0)

		// Sort and search a "List" of Integers
		List<Integer> lst = new ArrayList<Integer>();
		lst.add(22); // auto-box
		lst.add(11);
		lst.add(44);
		lst.add(33);
		Collections.sort(lst); // Use the Comparable of Integer class
		System.out.println(lst); // [11, 22, 33, 44]
		System.out.println(Collections.binarySearch(lst, 22)); // 1
		System.out.println(Collections.binarySearch(lst, 35)); // -4 (insertion at index 3)
	}

	private static void ArrayListCustomObject() {
		List<Car> cars = new ArrayList<Car>();
		cars.add(new Car("Skoda Fabia", "Green", 120000));
		cars.add(new Car("Bugatti", "Blue", 12000000));
		cars.add(new Car("Jyguli", "White", 28000));
		
		for (Car car : cars) {
			car.Show();
		}
		Collections.sort(cars, new SortbyPrice());
		
		for (Car car : cars) {
			car.Show();
		}
	}
}
