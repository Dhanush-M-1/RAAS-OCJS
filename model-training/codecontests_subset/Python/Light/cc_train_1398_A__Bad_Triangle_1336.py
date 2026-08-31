# Anuneet Anand

T = int(input())

while T:
	n = int(input())
	A = list(map(int,input().split()))
	a = A[0]
	b = -1
	c = A[n-1]
	k = -1
	for i in range(1,n-1):
		if a+A[i]<=c:
			b = A[i]
			k = i+1
			break
	if b>0:
		print(1,k,n)
	else:
		print(-1)
	T = T - 1
