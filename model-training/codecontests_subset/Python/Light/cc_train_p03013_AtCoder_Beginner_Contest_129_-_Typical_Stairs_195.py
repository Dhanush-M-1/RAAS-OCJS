n,m=map(int,input().split())
mod=10**9+7
A=[1]*(n+1)
for i in range(m):
  A[int(input())]=0
B=[1]*(n+1)
if A[1]==0:
  B[1]=0
for i in range(2,n+1):
  B[i]=A[i]*(B[i-1]+B[i-2])%mod
print(B[n])