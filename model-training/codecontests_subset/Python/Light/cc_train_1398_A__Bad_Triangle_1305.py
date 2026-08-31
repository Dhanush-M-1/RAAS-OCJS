t = int(input())

arrs = []
for i in range(t):
	_ = int(input())
	arr = [int(j) for j in input().split()]
	arrs.append(arr)


for arr in arrs:
	a1 = arr[0]
	a2 = arr[1]
	a3 = arr[-1]
	if a1+a2 > a3:
		print(-1)
	else:
		print(1,2,len(arr))
		