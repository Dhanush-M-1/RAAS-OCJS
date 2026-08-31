i=input
N=int(i())
A=list(map(int,i().split()))
r=range
c=0
for i in r(N):
    m=i
    for j in r(i,N):
        if A[j] < A[m]:m=j
    if i!=m:A[i],A[m]=A[m],A[i];c+=1
print(*A)
print(c)