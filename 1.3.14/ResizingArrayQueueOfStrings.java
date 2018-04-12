import java.util.NoSuchElementException;

/**
 * 习题 1.3.14
 * 
 * 思路：1，队列元素需要两个指示标记，first和last
 *      2，当last超出数组长度，按照数组元素数量两倍，创建新数组，并复制first和last之间的数据
 *      3，当队列元素数量只有数组的四分之一，则按照二分之一，创建新数组，并复制first和last之间的数据
 */

public class ResizingArrayQueueOfStrings
{
    private String[] arr;
    // first 表示队列头的元素，last 表示队列尾元素的后一位
    private int first;
    private int last;


    ResizingArrayQueueOfStrings() {
        arr = new String[1];
    }

    private void resize(int max) {
        String[] tmp = new String[max];
        for (int i = first, j = 0; i < last; i++, j++) {
            tmp[j] = arr[i];
        }
        arr = tmp;
        last -= first;
        first = 0;
        // System.out.println("arr's size is " + arr.length);
    }

    public void enqueue(String s) {
        if (last == arr.length) {
            resize(arr.length * 2);
        }
        arr[last] = s;
        last++;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");
        }
        String tmpStr = arr[first];
        first++;
        if (last - first == arr.length / 4) {
            resize(arr.length / 2);
        }
        return tmpStr;
    }

    public boolean isEmpty() {
        return first == last;
    }

    public int size() {
        return last - first;
    }

    // public int arrLength() {
    //     return arr.length;
    // }
}