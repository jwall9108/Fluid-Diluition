
public class Main {

	public static int chem1;
	public static int chem2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	double i = 	calculateDilution(1, 5, 4);
	
	i++;
	
	}

	private static double calculateDilution(double iterations, double capactity, double replaced) {
		for (int i = 0; i < 7; i++) {
			System.out.println((1- (Math.pow(1 -(replaced/capactity), i)))*100);
		}	
		return (1- (Math.pow(1 -(replaced/capactity), iterations)))*100;

	}

}
