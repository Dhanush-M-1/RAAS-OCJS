N = int(input())
A = list(map(int, input().split()))
count = 0
for i in range(N-1):
    minidx = i
    for j in range(i+1,N):
        if A[j] < A[minidx]:
            minidx = j
    if minidx != i:
        A[i], A[minidx] = A[minidx], A[i]
        count += 1
print(*A); print(count)
