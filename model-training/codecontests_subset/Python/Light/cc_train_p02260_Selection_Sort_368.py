n = int(input())
A = list(map(int, input().split()))
counter = 0
for i in range(0, n):
  minj = i
  for j in range(i, n):
    if A[j] < A[minj]:
      minj = j
  A[i], A[minj] = A[minj], A[i]
  if i != minj:
    counter += 1
print(*A, sep=" ")
print(counter)
