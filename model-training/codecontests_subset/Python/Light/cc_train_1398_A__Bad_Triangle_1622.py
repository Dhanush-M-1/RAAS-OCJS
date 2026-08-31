for i in range(int(input())):
	n =int(input())
	lst=list(map(int,input().split()))
	A=lst
	A.sort()
	a1=[]
	b=1
	first=A[0]
	second=A[1]
	for i in range(2,n):
		if(first+second<=A[i] or first+A[i]<=second or second+A[i]<=first):
			print(1,2,i+1)
			b=0
			break
		
	if(b==1):
		print(-1)
