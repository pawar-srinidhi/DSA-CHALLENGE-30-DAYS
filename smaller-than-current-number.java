class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int largest=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            largest=Math.max(nums[i],largest);
        }

        int[] bucket=new int[largest+1];

        for(int num:nums){
            bucket[num]++;
        }
        for(int i=1;i<bucket.length;i++){
            bucket[i]+=bucket[i-1];
        }

        int[] result=new int[nums.length];
        for(int i=0;i<result.length;i++){
            if(nums[i]==0){
                result[i]=0;
            }else{
                result[i]=bucket[nums[i]-1];
            }
        }
        return result;
    }
}