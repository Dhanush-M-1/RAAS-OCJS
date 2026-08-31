#selection sort

n = int(input())

A = list(map(int,input().split()))

count = 0
for i in range(0,n):
    minj = i
    for j in range(i,n):
        if A[j] < A[minj]:
            minj = j

    if i != minj:
        count += 1
        A[i],A[minj] = A[minj],A[i]


print(*A)
print(count)
