package More;

import java.util.List;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
