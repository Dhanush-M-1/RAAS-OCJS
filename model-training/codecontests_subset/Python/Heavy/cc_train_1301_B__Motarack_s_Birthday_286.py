for _ in range(int(input())):
	N=int(input())
	L=list(map(int,input().split()))
	FLAG=0
	Min=10**9+1
	Max=-1
	for i in range(N):
		if L[i]!=-1:
			if L[i]>Max:
				Max=L[i]
			if L[i]<Min:
				Min=L[i]
	MAXIMUM=-1
	if Max==-1:
		print(0,0)
		continue
	Min=10**9+1
	Max=-1
	MAXIMUM=-1
	for i in range(N-1):
		if L[i]!=-1 and L[i+1]!=-1:
			if MAXIMUM<abs(L[i]-L[i+1]):
				MAXIMUM=abs(L[i]-L[i+1])
		if L[i]!=-1 and L[i+1]==-1:
			if Max<L[i]:
				Max=L[i]
			if Min>L[i]:
				Min=L[i]
		if L[i]==-1 and L[i+1]!=-1:
			if Max<L[i+1]:
				Max=L[i+1]
			if Min>L[i+1]:
				Min=L[i+1]
	A=(Max+Min)//2
	if MAXIMUM==-1:
		print(Max-A,A)
	else:
		if MAXIMUM>=Max-A:
			print(MAXIMUM,A)
		else:
			print(Max-A,A)