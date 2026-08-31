n,k=map(int,input().split())
l=list(map(int,input().split()))
v=[]
for i in range(n):
	if k%l[i]==0:
		v.append(l[i])
a=max(v)

print(k//a)