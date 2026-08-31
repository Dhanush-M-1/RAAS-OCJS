n = int(input())
*A, = map(int, input().split())
ans = 0

for i in range(n):
  minj = i
  for j in range(i, n):
    if A[j] < A[minj]:
      minj = j
  if i != minj:
    A[i], A[minj] = A[minj], A[i]
    ans += 1

print(*A)
print(ans)
