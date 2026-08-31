N = int(input())
A = list(map(int, input().split()))
sum = 0

for i in range(N):
    minj = i
    for j in range(i, N):
        if A[j] < A[minj]:
            minj = j
    if i != minj:
        v = A[i]
        A[i] = A[minj]
        A[minj] = v
        sum += 1
print(*A)
print(sum)
