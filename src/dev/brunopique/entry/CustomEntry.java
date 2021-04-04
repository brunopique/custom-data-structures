package dev.brunopique.entry;

import java.util.HashSet;
import java.util.Set;

public class CustomEntry {

    private Integer key;
    private String value;
    private static final Set<Integer> keys = new HashSet<>();

    public CustomEntry(Integer key, String value) {
        if (!keys.add(key)) {
            System.out.println("Key already exists!");
            return;
        }
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public CustomEntry getEntry(String value) {
        if (this.value.equals(value))
            return this;
        return new CustomEntry(0, "");
    }

    @Override
    public String toString() {
        return "CustomEntry{" +
                "key=" + key +
                ", value='" + value + '\'' +
                '}';
    }
}
