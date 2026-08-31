N, *A = map(int, open(0).read().split())
ans = 0
for i in range(N):
    minj = i
    for j in range(i, N):
        if A[j] < A[minj]:
            minj = j
    if i != minj:
        A[i], A[minj] = A[minj], A[i]
        ans += 1
print(' '.join(map(str, A)))
print(ans)
