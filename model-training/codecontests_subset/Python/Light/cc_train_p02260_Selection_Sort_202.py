n = int(input())
A = list(map(int, input().split()))

counter = 0

for i in range(n):
    minj = i
    for j in range(i, n):
        if A[j] < A[minj]:
            minj = j
    if i != minj:
        A[i], A[minj] = A[minj], A[i]
        counter += 1

print(*A)
print(counter)

