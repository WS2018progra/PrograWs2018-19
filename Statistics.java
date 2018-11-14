public class Statistics {
	public boolean hasAnElement=false;
	private int position=0;
	public int[] data=new int[100];
	public static void main(String[] args) {
		Statistics statistics = new Statistics();
		statistics.addValue(2);
		statistics.addValue(105);
		statistics.addValue(-366);
		statistics.addValue(44);
		statistics.addValue(11);
		SimpleIO.output("Minimum: " + statistics.getMinimum());
		SimpleIO.output("Maximum: " + statistics.getMaximum());
		SimpleIO.output("Durchschnitt: " + statistics.getAverage());
	}

	// ...

	public void addValue(int value) {
		if(position==100)System.out.println("Error Array is full");
		else{
			data[position]=value;
			position++;
			hasAnElement=true;
		}
	}

	public int getMinimum() {
		if(hasAnElement){
			int i=0;
			int Minimum=Integer.MAX_VALUE;
			while(i<position){
				if(data[i]<Minimum)Minimum=data[i];
				i++;
			}
			return Minimum;
		}
		System.out.println("Error no value was added before");
		return 0;
	}

	public int getMaximum() {
		if(hasAnElement){
			int i=0;
			int Maximum=Integer.MIN_VALUE;
			while(i<position){
				if(data[i]>Maximum)Maximum=data[i];
				i++;		
			}
			return Maximum;
		}
		System.out.println("Error no value was added before");
		return 0;
	}

	public double getAverage() {
		if(hasAnElement){
			double sum=0;
			double amount=0;
			for(int i=0;i<position;i++){
					sum+=data[i];
					amount+=1.0;
				}
			return sum/amount;
		}
		System.out.println("Error no value was added before");
		return 0;
	}
}

