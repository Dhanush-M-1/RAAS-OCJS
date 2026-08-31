N = int(input())
A = list(map(int, input().split()))
sw = 0
for i in range(N):
    minj = i
    for j in range(i, N):
        if A[j] < A[minj]:
            minj = j
    if (i != minj):
        sw += 1
        A[i], A[minj] = A[minj], A[i]
    
print(" ".join(map(str, A)))
print(sw)
