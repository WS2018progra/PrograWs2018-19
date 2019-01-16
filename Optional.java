import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Optional<T> {
	public static <T> Optional<T> empty() {
		return new Optional<>(null);
	}

	public static <T> Optional<T> present(T value) {
		if (value != null) {
			return new Optional<>(value);
		} else {
			throw new IllegalArgumentException("parameter cannot be null");
		}
	}

	private final T value;

	public Optional(T value) {
		this.value = value;
	}

	public boolean isPresent() {
		return value != null;
	}

	public T get() {
		if (value != null) {
			return value;
		} else {
			throw new IllegalStateException("cannot get empty value");
		}
	}

	//a)
	public <R> Optional<R> map(Function<T, R> mapper) {
		if(!this.isPresent())return Optional.empty();
		else return new Optional<R>(mapper.apply(this.get()));
	}

	//b)
	public Optional<T> filter(Predicate<T> tester) {
		if(!this.isPresent())return Optional.empty();
		else return tester.test(this.get()) ? this : Optional.empty();			
	}
	

	//c)
	public <R> R fold(Function<T, R> presentMapper, Supplier<R> emptyReplacer) {
		if(!this.isPresent())return emptyReplacer.get();
		else return presentMapper.apply(this.get());
	}
	
}

