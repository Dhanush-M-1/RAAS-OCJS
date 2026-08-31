N=int(input()) 
A=list(map(int,input().split()))
n=0
for i in range(N):
    minj = i
    for j in range(i,N):
        if A[j] < A[minj]:
            minj=j
    if minj != i:
        x=A[i]
        A[i]=A[minj]
        A[minj]=x
        n+=1
print(*A)
print(n)
