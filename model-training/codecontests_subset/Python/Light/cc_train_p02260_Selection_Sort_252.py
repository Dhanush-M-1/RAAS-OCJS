n = int(input())
a = list(map(int,input().split()))
counter = 0
for i in range(n):
	minj = i
	for j in range(i,n):
		if a[j] < a[minj]:
			minj = j
	if minj != i:
		k = a[i]
		a[i] = a[minj]
		a[minj] = k
		counter += 1
ans = list(map(str,a))
print(" ".join(ans))
print(counter)
