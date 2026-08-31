import math
getInputList = lambda : list(input().split())
getInputIntList = lambda : list(map(int,input().split()))

n , k = getInputIntList()
arr = list(getInputIntList())
bin_arr = [True] * n
arr.sort(reverse = True)
myset = set([])
i = len(arr)-1
while i > 0:
	if arr[i-1] > arr[i] and arr[i-1] <= arr[i] + k:
		bin_arr[i] = False
		myset.add(arr[i])
	i -= 1

i = len(arr)-1
while i > 0:
	if arr[i] in myset:
		
		bin_arr[i] = False
		i -= 1
		continue
	if arr[i-1] > arr[i] and arr[i-1] <= arr[i] + k:
		bin_arr[i] = False
	i -= 1		

print(bin_arr.count(True))	
