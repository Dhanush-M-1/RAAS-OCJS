N = int(input())
A = [int(x) for x in input().split()]
times = 0

for i in range(N):
    minj = i
    for j in range(i, N):
        if A[j] < A[minj]:
            minj = j
    if i != minj:
        times += 1
    A[i], A[minj] = A[minj], A[i]
  


print(*A)
print(times)