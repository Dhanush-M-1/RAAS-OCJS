import sys
input = sys.stdin.readline
mod=10**9+7
mxi=210000
ans=[0]*mxi
cts=[0]*10
cts[0]=1
s=1
for i in range(mxi):
    ans[i]=s
    s+=cts[-1]
    s%=mod
    cts[0]+=cts[-1]
    cts[0]%=mod
    cts.insert(0,cts.pop())
for f in range(int(input())):
    n,m=map(int,input().split())
    sol=0
    for x in str(n):
        sol+=ans[m+int(x)]
        sol%=mod
    print(sol)
    