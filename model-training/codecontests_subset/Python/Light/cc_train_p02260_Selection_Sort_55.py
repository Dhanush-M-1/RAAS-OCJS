n = int(input())

A = [int(s) for s in input().split()]

cnt = 0
for i in range(n):
    mini = i
    for j in range(i, n):
        if A[j] < A[mini]:
            mini = j
    if i != mini:
        A[i], A[mini] = A[mini], A[i]
        cnt += 1

print(*A)
print(cnt)
