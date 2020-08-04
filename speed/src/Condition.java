
import java.util.Objects;

public class Condition {
    private final long start;
    private final long end;

    public Condition(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public boolean match(long value) {
        return value >= start & value < end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Condition condition = (Condition) o;
        return start == condition.start &&
                end == condition.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
