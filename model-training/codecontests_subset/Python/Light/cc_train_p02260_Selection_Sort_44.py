N=int(input())
A=list(map(int,input().split()))
count=0
for i in range(N):
    minj = i
    for j in range(i,N):
        if A[j] < A[minj]:
            minj=j
    if i!=minj:
        count+=1
    R=A[i]
    A[i]=A[minj]
    A[minj]=R
Z=[str(a) for a in A]
Z=" ".join(Z)
print(Z)

print(count)

