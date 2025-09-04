class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Step 1: Sort
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1]; // same height → smaller k first
            return b[0] - a[0]; // taller first
        });

        // Step 2: Insert into list
        List<int[]> result = new ArrayList<>();
        for (int[] p : people) {
            result.add(p[1], p);
        }

        // Step 3: Convert to array
        return result.toArray(new int[people.length][]);
    }
} 
    