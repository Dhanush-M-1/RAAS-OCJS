n,k=map(int,input().split())
l=list(map(int,input().split()))
l2=[]
for i in l:
	if k%i==0:
		l2.append(k//i)
print(min(l2))