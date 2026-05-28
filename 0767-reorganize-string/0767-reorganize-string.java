class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(freqMap.getOrDefault(b,0),freqMap.getOrDefault(a,0)));

        for(char c : s.toCharArray()) {
            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
        }

        for(char c : freqMap.keySet()) {
            maxHeap.add(c);
        }

        StringBuilder sb = new StringBuilder();

        while(!maxHeap.isEmpty()) {
            char c = maxHeap.remove();

            if(sb.length() > 0 && sb.charAt(sb.length()-1)==c) {
                if(maxHeap.isEmpty()) {
                    return "";
                }
                char c2 = maxHeap.remove();
                sb.append(c2);
                if(freqMap.get(c2)>1) {
                    freqMap.put(c2,freqMap.get(c2)-1);
                    maxHeap.add(c2);
                }
                maxHeap.add(c);
            } else {
                sb.append(c);
                if(freqMap.get(c)>1) {
                    freqMap.put(c,freqMap.get(c)-1);
                    maxHeap.add(c);
                }
            }
            
        }
        return sb.toString();
    }
}