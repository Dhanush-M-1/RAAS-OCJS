N = int(input())
A = list(map(int, input().split()))

c = 0
for i in range(N):
  mat = i
  for j in range(i, N):
    if A[j] < A[mat]:
      mat = j
  if i != mat:
    t = A[i]
    A[i] = A[mat]
    A[mat] = t
    c += 1

print(" ".join(map(str, A)))
print(c)
