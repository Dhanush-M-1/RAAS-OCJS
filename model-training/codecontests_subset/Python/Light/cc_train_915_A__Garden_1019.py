n,k=map(int,input().split())
l=list(map(int,input().split()))
m=k
for i in l:
	if k%i==0 and k//i<m:
		m=k//i
print(m)		