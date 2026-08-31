N = int(input())
A = list(map(int, input().split()))
count = 0

for i in range(N):
    mini = i
    for j in range(i, N):
        if A[j] < A[mini]:
            mini = j
    if i != mini:
        A[i], A[mini] = A[mini], A[i]
        count += 1

print(*A)
print(count)