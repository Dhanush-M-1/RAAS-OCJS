import random

def del_nulls(arr):
	x = {}
	count, i = 0, -1
	while i < len(arr) - 1:
		i += 1
		count += 1
		if arr[i] in x: 
			x[arr[i]] += 1
			arr.remove(arr[i])
			i -= 1
		else: x.update([(arr[i], 1)])
	return(x)

def qsort(arr, left, right):
  if (right - left > 1):
    a = (right + left)//2
    l, r = left, right
    while (l != r):
      while (arr[l] < arr[a]): l += 1
      while (arr[r] > arr[a]): r -= 1
      if (l > r):
        l, r = r, l
      else:
        arr[l], arr[r] = arr[r], arr[l]
    if (l != right):
      qsort(arr, left, l)
    if (r != left):
      qsort(arr, r, right)
  elif (arr[left] > arr[right]):
    arr[left], arr[right] = arr[right], arr[left]
		
arr = list(map(int, input().split('+')))

del_list = del_nulls(arr)

qsort(arr, 0, len(arr) - 1)
for i in range(0, len(arr)):
	for j in range(0, del_list[arr[i]]):
		if (not(i == 0 and j == 0)): print('+', end='')
		print(arr[i], end='')