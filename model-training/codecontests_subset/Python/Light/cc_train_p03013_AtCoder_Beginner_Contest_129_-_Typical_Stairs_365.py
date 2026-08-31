N, M = map(int, input().split())
A = set(int(input()) for i in range(M))
x = [0] * (N+1)
x[0] = 1
 
for i in range(1, N+1): 
  if i in A: x[i] = 0
  else:
    x[i] = (x[i-1] + x[i-2])%(10**9+7)
    
print(x[N])