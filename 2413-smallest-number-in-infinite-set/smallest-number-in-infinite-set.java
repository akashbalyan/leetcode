import java.util.PriorityQueue;
import java.util.HashSet;

class SmallestInfiniteSet {
    private PriorityQueue<Integer> pq; // Min-heap to get the smallest number
    private HashSet<Integer> set; // Track numbers present in the queue
    private int nextSmallest; // Track the next smallest number not in pq

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        nextSmallest = 1; // The first smallest number is 1
    }
    
    public int popSmallest() {
        if (!pq.isEmpty()) {
            int num = pq.poll();
            set.remove(num); // Remove from set
            return num;
        }
        
        return nextSmallest++; // Otherwise, return next natural number
    }
    
    public void addBack(int num) {
        if (num < nextSmallest && set.add(num)) { // Only add if it's smaller than nextSmallest and not already present
            pq.add(num);
        }
    }
}

/**
 * Example Usage:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int smallest = obj.popSmallest();
 * obj.addBack(2);
 */
