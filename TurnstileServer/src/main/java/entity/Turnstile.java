package entity;

/**
 *
 * @author joaci
 */
public class Turnstile {
    private final int count;
    private final String name;

    public Turnstile(String name, int count) {
        this.count = count;
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Turnstile{" + "count=" + count + ", name=" + name + '}';
    }
    
    
}
