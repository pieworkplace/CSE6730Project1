import java.util.ArrayList;
import java.util.List;

public abstract class Heap<T> {

    public List<T> heap;

    Heap() {
        heap = new ArrayList<>();
    }

    public void heappush(T item){
        heap.add(item);
        heapifyUp(heap.size() - 1);
    }

    public T heappop(){
        if (heap.size() == 0){
            return null;
        }
        T res = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return res;
    }

    abstract boolean priorThan(T item1, T item2);

    private void heapifyDown(int i) {
        if ((2 * i + 1) >= heap.size()){
            return;
        }
        else if ((2 * i + 2) >= heap.size()){
            if (priorThan(heap.get(i), heap.get(2 * i + 1))){
                return;
            }
            else{
                T tmp = heap.get(i);
                heap.set(i, heap.get(2 * i + 1));
                heap.set((2 * i + 1), tmp);
                heapifyDown(2 * i + 1);
            }
        }
        else if (priorThan(heap.get(i), heap.get(2 * i + 1)) && priorThan(heap.get(i), heap.get(2 * i + 2))){
            return;
        }
        else if (priorThan(heap.get(2 * i + 1), heap.get(2 * i + 2))){
                T tmp = heap.get(i);
                heap.set(i, heap.get((2 * i + 1)));
                heap.set((2 * i + 1), tmp);
                heapifyDown(2 * i + 1);
        }
        else {
            T tmp = heap.get(i);
            heap.set(i, heap.get(2 * i + 2));
            heap.set(2 * i + 2, tmp);
            heapifyDown(2 * i + 2);
        }

    }

    private void heapifyUp(int i){
        if(i == 0){
            return;
        }
        if(priorThan(heap.get(i), heap.get((i - 1) / 2))){
            T tmp = heap.get(i);
            heap.set(i, heap.get((i - 1) / 2));
            heap.set((i - 1) / 2, tmp);
            heapifyUp((i - 1) / 2);
        }
    }
}
