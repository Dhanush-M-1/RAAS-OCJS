n,m=map(int,input().split())
A = [int(input()) for i in range(m)]
ls =[-1]*(n+1)
ls[0]=ls[1]=1
mod = 10**9+7
for a in A:
	ls[a]= 0

for i in range(2,n+1):
	if ls[i]==-1:
		ls[i]= ls[i-1]+ls[i-2]
print(ls[-1]%mod)