import sys
input=sys.stdin.readline
n,k=map(int,input().split())
mod=998244353
lr=[list(map(int,input().split())) for i in range(n)]
f=[0]*(n+1)
f[0]=1
for i in range(1,n+1):
  f[i]=(f[i-1]*i)%mod
inv_f=[1]*(n+1)
inv_f[n]=pow(f[n],mod-2,mod)
for i in range(n-1,1,-1):
  inv_f[i]=(inv_f[i+1]*(i+1))%mod
def comb(m,r,mod):
  if 0<=r<=m:
    return f[m]*inv_f[r]*inv_f[m-r]%mod
  else:
    return 0
e=[2*t for t,_ in lr]+[2*t+1 for _,t in lr]
e.sort()
cur=0;ans=0
for t in e:
  if t%2:
    cur-=1
  else:
    ans+=comb(cur,k-1,mod)
    ans%=mod
    cur+=1
print(ans)