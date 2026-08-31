import sys
input=sys.stdin.buffer.readline #FOR READING PURE INTEGER INPUTS (space separation ok)

MOD=998244353


n,k=[int(x) for x in input().split()]
start=[]
end=[]
for _ in range(n):
    s,e=[int(x) for x in input().split()]
    start.append(s)
    end.append(e)
start.sort()
end.sort()

nCr=dict() #nCr[(n,k-1)]=value precomputation
den=1
for N in range(k-1):
    den = (den * (N + 1)) % MOD 
num=den
nCr[(k-1,k-1)]=1
divisor=1
for N in range(k,n+1):
    num=(num*N)%MOD
    num=((num%MOD)*pow(divisor,MOD-2,MOD))%MOD
    nCr[(N,k-1)]=((num%MOD)*pow(den,MOD-2,MOD))%MOD
    divisor+=1

#print(start)
#print(end)
ans=0
ei=-1
contains=0
for si in range(n):
    contains+=1
    while ei<n-1 and end[ei+1]<start[si]: #if end[ei]==start[si], don't subtract yet, since we want inclusive
        ei+=1
        contains-=1
#    print('si:{} ei:{} contains:{}'.format(si,ei,contains))
    if contains-1>=k-1:
        ans+=nCr[(contains-1,k-1)] #number of combinations including this new si
        ans%=MOD

print(ans)