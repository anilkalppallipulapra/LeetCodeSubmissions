int largestAltitude(int* gain, int gainSize){
    int* prefixSum = (int*)malloc((gainSize + 1) * sizeof(int));
    *prefixSum = 0;
    int maxAltitude = 0;

    for (int i = 1; i <= gainSize; i++) {
        *(prefixSum +i) = *(prefixSum + (i - 1)) + *(gain + (i - 1));
        if (*(prefixSum + i) > maxAltitude) {
            maxAltitude = *(prefixSum + i);
        }
    }

    free(prefixSum);  

    return maxAltitude;
}