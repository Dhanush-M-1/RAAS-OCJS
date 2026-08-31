N = int(input())

A = list(map(int, input().split()))
cnt = 0

for i in range(N):
    minj = i
    for j in range(i, N):
        if A[j] < A[minj]:
            minj = j
    A[i], A[minj] = A[minj], A[i]
    if A[i] != A[minj]:
        cnt += 1

print(' '.join(map(str,A)))
print(cnt)
