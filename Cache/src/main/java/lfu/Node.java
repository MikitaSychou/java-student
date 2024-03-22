package lfu;

public class Node {

   private String data;
   private int frequency;

    public Node() {

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getIncrementedFrequency() {
        return frequency++;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
