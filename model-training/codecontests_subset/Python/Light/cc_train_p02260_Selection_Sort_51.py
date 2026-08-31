N = int(input())
A = list(map(int, input().split()))
count = 0
for i in range(N):
    m = i
    for j in range(i + 1, N):
        if A[j] < A[m]:
            m = j
    if m > i:
        A[i], A[m] = A[m], A[i]
        count += 1
print(' '.join(list(map(str, A))))
print(count)

