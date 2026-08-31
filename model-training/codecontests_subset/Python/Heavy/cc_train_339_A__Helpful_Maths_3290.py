def sort(a, start, end):
	arr = []
	if end - start == 1:
		arr.append(a[start])
		return arr
	arr1 = sort(a, start, int((start+end)/2))
	arr2 = sort(a, int((start+end)/2), end)
	i = 0
	j = 0
	while (i != len(arr1)) and (j != len(arr2)):
		if arr1[i] < arr2[j]:
			arr.append(arr1[i])
			i += 1
		else:
			arr.append(arr2[j])
			j += 1
	while i<len(arr1):
		arr.append(arr1[i])
		i+=1
	while j<len(arr2):
		arr.append(arr2[j])
		j+=1
	return arr

s = input()
a = s.split('+')
a = sort(a,0,len(a))
for i in range(len(a)):
	if i+1 == len(a):
		print(a[i]) 
	else:
		print(f'{a[i]}+', end = '')