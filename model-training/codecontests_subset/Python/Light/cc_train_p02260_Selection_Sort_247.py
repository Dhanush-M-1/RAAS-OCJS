N=int(input())
A=[int(i) for i in input().split()]
ans=0
for i in range(N):
    minj=i
    for j in range(i,N):
        if A[j]<A[minj]:
            minj=j
    if i!=minj:
        A[i],A[minj]=A[minj],A[i]
        ans+=1
print(" ".join([str(i) for i in A]))
print(ans)

