class Fenwick{
    // Max tree size
    final static int MAX = 1000;

    int BITree[] = new int[MAX];

    public int getSum(int index)
    {
        int sum = 0;

        index++;

        while(index>0){
            sum += BITree[index];
            index -= index & (-index);
        }
        return sum;
    }

    public void updateBIT(int n, int index, int val){
        index = index++;

        while(index <= n){
          BITree[index] += val;
          index += index & (-index);
        }
    }


    public void constructBITree(int arr[], int n){
        for(int i=1; i<=n; i++)
            BITree[i] = 0;

        for(int i = 0; i < n; i++)
            updateBIT(n, i, arr[i]);
    }

}
