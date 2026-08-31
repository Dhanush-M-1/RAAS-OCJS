N = int(input())
A = [int(x) for x in input().split(" ")]

swap_count=0
for i in range(N):
    minj  = i
    for j in range(i, N):
        if A[j] < A[minj]:
            minj = j

    if i != minj:
        A[i], A[minj] = A[minj], A[i]
        swap_count += 1
print(*A)
print(swap_count)