public class Article {
	private final String name;
	private final int price;

	public Article(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public boolean isHumanEatable() {
		return !name.equals("Dog Food");
	}

	public Article adjustPrice() {
		if (price < 1000) {
			return new Article(name, price * 2);
		} else {
			return this;
		}
	}

	public String stringify() {
		return "The Article named '" + name + "' costs " + price + " cent.";
	}
}

