public void mergeSort() {
	long[] res = new long[nElems];
	recMergeSort(res, 0, nElems-1);
}

public void recMergeSort(long[] res, int left, int right) {
	if(left==right)
		return;
	else {
		int mid = (left+right)/2;
		recMergeSort(res, left, mid);
		recMergeSort(res, mid+1, right);
		merge(res, left, mid+1, right);
	}
}

public void merge(long[] res, int left, int m, int right) {
	int index = 0, l = left, mid = m-1, n = right-left+1;

	while(left<=mid && m<=right) {
		if(arr[left]<arr[m])
			res[index++] = arr[left++];
		else
			res[index++] = arr[m++];
	}

	while(left<=mid)
		res[index++] = arr[left++];
	while(m<=right)
		res[index++] = arr[m++];

	for(int i=0; i<n; i++) {
		arr[l+i] = res[i];
	}
}