N, M = map(int, input().split())
a = set(int(input()) for i in range(M)) 

A = [1] + [0] * (N)

for i in range(1, N+1):
  if i in a:
    A[i] = 0
  else:
    A[i] = (A[i-1] + A[i-2]) % (10 ** 9 + 7)

print (A[-1])  