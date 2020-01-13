import java.util.*;

public class MainApp {

	public static void main(String[] args) {

		// System.out.println("�����!");
		System.out.println("Parameter length: "+args.length);
		if(args.length>0)
		{
			System.out.println(args[0]);
		}
		try {
			Scanner in = new Scanner(System.in);
			int[] nums = new int[5];
			for (int i = 0; i < nums.length; i++) {
				System.out.printf("->_");
				nums[i] = in.nextInt();
			}
			for (int i = 0; i < nums.length; i++) {
				System.out.printf("%d\t", nums[i]);
			}
			in.close();
		}
		catch(InputMismatchException ex) {
			System.out.println("�������� ����� �����!");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
