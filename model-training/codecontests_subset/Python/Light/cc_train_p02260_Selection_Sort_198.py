N = int(input())
A = list(map(int, input().split()))
swap = 0
for i in range(N):
    minj = i
    for j in range(i, N):
        if A[j] < A[minj]:
            minj = j
    A[i], A[minj] = A[minj], A[i]
    if i != minj:
        swap += 1
print(" ".join(list(map(str, A))))
print(swap)