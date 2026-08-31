N = int(input())
A = list(map(int,input().split()))

change=0
for i in range(N):
    mini = i
    for j in range(i+1,N):
        if A[mini]>A[j]:
            mini = j 
    if A[i] != A[mini]:
        A[i],A[mini] = A[mini],A[i]
        change += 1

print(" ".join(map(str,A)))
print(change)
