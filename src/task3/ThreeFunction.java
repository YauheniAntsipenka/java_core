package task3;

@FunctionalInterface
public interface ThreeFunction<T> {
    T getResult(T t1, T t2, T t3);
}
