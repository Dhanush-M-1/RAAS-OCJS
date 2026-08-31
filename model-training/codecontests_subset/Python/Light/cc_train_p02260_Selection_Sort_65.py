n=int(input())
A =list(map(int,input().split()))
count=0
for i in range(n-1):
	minj = i
	for j in range(i+1,n):
		if A[j]<A[minj]:
			minj=j
	A[i],A[minj]=A[minj],A[i]
	if minj != i:
		count+=1
print(' '.join(list(map(str,A))))
print(count)



