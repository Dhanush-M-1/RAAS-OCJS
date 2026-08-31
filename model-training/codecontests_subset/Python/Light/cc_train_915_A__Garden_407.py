n,k=map(int,input().split())
m=n
a=sorted(list(map(int,input().split())))
#print(a)
for i in range(n):
	if  k% a[m-i-1]==0:
		print(k//a[m-i-1])
		break
