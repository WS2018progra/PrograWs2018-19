public class Store {
	public static void main(String[] args) {
		System.out.println(toPriceTag(new Article("Dog Food", 1000)));
		System.out.println(toPriceTag(new Article("Pizza", 1000)));
		System.out.println(toPriceTag(new Article("Pizza", 100)));
	}
	
	//d)
	private static String toPriceTag(Article article) {
		Optional<Article>optionalArticle=Optional.present(article);
		optionalArticle=optionalArticle.filter(Article::isHumanEatable);
		optionalArticle=optionalArticle.map(Article::adjustPrice);

		return optionalArticle.fold(Article::stringify,()->"This Article is unavailable"); 
	}
}

