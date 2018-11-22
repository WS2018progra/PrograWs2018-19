import java.util.Arrays;
public class Minimum{
	public static int arrayMin(int[] inputArray){
        return calcMin(inputArray, 0, inputArray[0]);
	}

	public static int calcMin(int[] inputArray, int i,int minimum){
		if(inputArray.length==0){
			return Integer.MAX_VALUE;
		}
		else if(i<inputArray.length){
			if(inputArray[i]<minimum){
				minimum=inputArray[i];
			}
			i++;
			minimum=calcMin(inputArray, i, minimum);
		}
		return minimum;
	}
}
