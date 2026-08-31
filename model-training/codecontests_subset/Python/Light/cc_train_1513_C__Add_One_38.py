from sys import stdin
t=int(stdin.readline())
mod=10**9+7
f=[0]*(2*10**5+10)
for i in range(10):
  f[i]=1
f[10]=2
for i in range(11,2*10**5+10):
  f[i]=(f[i-10]+f[i-9])%mod
for _ in range(t):
  n,m=map(int,stdin.readline().split())
  c=[0]*10
  n=str(n)
  for i in range(len(n)):
    c[int(n[i])]+=1
  ans=0
  for i in range(10):
    ans+=c[i]*f[m+i]
    ans%=mod
  print(ans)