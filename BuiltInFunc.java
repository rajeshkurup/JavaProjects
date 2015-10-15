class BuiltInFunc {

	private static final int Arr[] = { 8, 1, 7, 2, 6, 3, 5, 4, 9, 0 };
	
	public static void main(String[] args) {
		
		for(int i = 0; i < Arr.length; ++i) {
			for(int j = i+1; j < Arr.length; ++j) {
				if(Arr[i] > Arr[j]) {
					int temp = Arr[i];
					Arr[i] = Arr[j];
					Arr[j] = temp;
				} else {
					// do nothing
				}
			}
		}
		
		for(int i : Arr) {
			System.out.println(i);
		}
	}

}
