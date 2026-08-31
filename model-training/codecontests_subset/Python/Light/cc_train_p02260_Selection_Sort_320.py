N = int(input())
A = list(map(int, input().split()))

cnt = 0
for i in range(N):
    index = i
    for j in range(i, N):
      if A[j] < A[index]:
        index = j
    if i != index:
      A[i], A[index] = A[index], A[i]
      cnt += 1
        
print(' '.join(map(str, A)))
print(cnt)
