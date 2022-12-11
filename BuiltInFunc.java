import java.lang.Math;

class BuiltInFunc {

	private static final int ArrSize = 10;
		
	public static void main(String[] args) {
		
		int[] arr = new int[ArrSize];
		for(int i = 0; i < ArrSize; ++i) {
			arr[i] = (int)(Math.random() * 1000);
		}
		
		for(int i = 0; i < arr.length; ++i) {
			for(int j = i+1; j < arr.length; ++j) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				} else {
					// do nothing
				}
			}
		}
		
		for(int i : arr) {
			System.out.println(i);
		}
	}

}
