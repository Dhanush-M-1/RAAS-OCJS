N,M=(map(int, input().split()))
A=[1]*(N+1)
for i in range(M):
  K=int(input())
  A[K]=0
  
#print(N,M,A)

for j in range(2,N+1):
  if A[j]!=0:
    A[j]=A[j-1]+A[j-2]
    
#print(A)
print(A[N]%(10**9+7))