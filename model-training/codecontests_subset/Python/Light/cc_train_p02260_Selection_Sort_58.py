N = int(input())
A = [int(x) for x in input().split()]
cnt = 0

for i in range(N):
    mini = i
    for j in range(i, N):
        if A[j] < A[mini]:
            mini = j
    if i != mini:
        A[i], A[mini] = A[mini], A[i]
        cnt +=1

print(" ".join(map(str, A)))
print(cnt)

