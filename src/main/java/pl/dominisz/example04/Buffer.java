package pl.dominisz.example04;

class Buffer {

    private int buffer[];
    private int getIndex;
    private int putIndex;

    public Buffer(int size) {
        buffer = new int[size];
    }

    public void put(int element) {
        if ((putIndex + 1) % buffer.length != getIndex) {
            buffer[putIndex] = element;
            putIndex = (putIndex + 1) % buffer.length;
        }
    }

    public int get() {
        if (putIndex != getIndex) {
            int element = buffer[getIndex];
            getIndex = (getIndex + 1) % buffer.length;
            return element;
        }
        return 0;
    }

}

