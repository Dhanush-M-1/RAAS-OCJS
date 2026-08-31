n=int(input())
A=list(map(int,input().split()))
count=0
for i in range(n):
    min=i
    for j in range(i,n):
        if A[j]<A[min]:
            min=j
    if min!=i:
        A[i],A[min]=A[min],A[i]
        count+=1
for i in range(n-1):
    print(A[i],end=" ")
print(A[n-1])
print(count)
