import java.util.Arrays;

public class Vector {

    private String[] elements;
    private int size;

    public Vector(int capacity) {
        this.elements = new String[capacity];
        this.size = 0;
    }

    public boolean add(String element) {
        this.addCapacity();

        if (this.size < elements.length) {
            this.elements[this.size] = element;
            this.size++;
            return true;
        }
        return false;
    }

    public boolean add(int index, String element) {
        this.addCapacity();

        if (!(index >= 0 && index <= size)) {
            throw new IllegalArgumentException("Index not exists");
        }

        for (int i = this.size - 1; i >= index; i--) {
            this.elements[i + 1] = this.elements[i];
        }
        this.elements[index] = element;
        this.size++;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder format = new StringBuilder();
        format.append("[");

        for (int i = 0; i < this.size - 1; i++) {

            format.append(this.elements[i]);
            format.append(", ");
        }
        if (this.size > 0) {
            format.append(this.elements[this.size - 1]);

        }
        format.append("]");

        return Arrays.toString(elements);
    }

    public int size() {
        int size = 0;
        for (int i = 0; i <= this.elements.length; i++) {
            size = i;
        }
        return size;
    }

    public int usedSize() {
        return size;
    }

    public String getByIndex(int index) throws Exception {
        if (!(index >= 0 && index < size)) {
            throw new IllegalArgumentException("Index not exists");
        }
        return this.elements[index];
    }

    public boolean existsByIndex(String element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equalsIgnoreCase(element)) {
                return true;
            }

        }
        return false;

    }

    private void addCapacity() {
        if (this.size == this.elements.length) {
            String[] newElements = new String[this.elements.length * 2];
            for (int i = 0; i < this.elements.length; i++) {
                newElements[i] = this.elements[i];

            }
            this.elements = newElements;
        }
    }

    public static void main(String[] args) throws Exception {

        Vector vetor = new Vector(2);

        vetor.add("Element 0");
        vetor.add("Element 1");
        vetor.add("outher Element");
        System.out.println(vetor);
        System.out.println(vetor.size);

    }

}
