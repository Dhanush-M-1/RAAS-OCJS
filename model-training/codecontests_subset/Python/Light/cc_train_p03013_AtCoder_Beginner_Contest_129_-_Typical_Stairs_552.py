N,M=map(int,input().split())
a=[int(input()) for _ in range(M)]+[10**6]
A=[0]*(N+2)
A[0:2]=[0,1]
j=0
for i in range(N):
    if i+1 != a[j]:
        A[i+2]=(A[i]+A[i+1])%(10**9+7)
    else:
        j+=1
print(A[N+1])