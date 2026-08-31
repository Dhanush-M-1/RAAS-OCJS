import io, os
input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline 
import math
z=998244353
def inv(a,b):
    return (pow(b, z-2, z)*(a%z))%z
n,k=list(map(int,input().split()))
lis=[0]*(n+1)
lis[k-1] = 1
for i in range(k, n+1):
    lis[i]=inv(lis[i-1]*i,i-k+1)
l=[]
r=[]
for i in range(n):
    u,v=list(map(int,input().split()))
    l.append(u)
    r.append(v)
l.sort()
r.sort()
i=0
j=0
p=0
ans=0
while i<n and j<n:
    if l[i]<=r[j]:
        ans+=lis[p]
        ans%=z
        p+=1
        i+=1
    else:
        p-=1
        j+=1
print(ans)