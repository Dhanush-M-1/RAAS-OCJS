N,M=map(int,input().split())
A=[0]*M
for i in range(M):
    A[i]=int(input())
A=set(A)

K=10**9+7

X=[0]*(N+1)
X[0]=1
X[1]=1*(1 not in A)

for i in range(2,N+1):
    if i not in  A:
        X[i]=(X[i-1]+X[i-2])%K
print(X[-1])
