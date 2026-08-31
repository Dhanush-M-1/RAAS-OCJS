num = int(input())
A=list(map(int,input().split(" ")))

chg = 0
for i in range(num-1):

	minv = i
	for j in range(i+1,num):
		if A[minv] > A[j]:
			minv = j

	if A[i] > A[minv]:
		A[i],A[minv] = A[minv],A[i]
		chg += 1
print(*A)
print(chg)

