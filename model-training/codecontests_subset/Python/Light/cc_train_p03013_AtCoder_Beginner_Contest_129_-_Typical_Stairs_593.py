n,m = map(int,input().split())
a = [int(input()) for _ in range(m)]
b = [1 for i in range(n+1)]
for i in a:
  b[i] = 0
for i in range(2,n+1):
  cnt = b[i-1] + b[i-2]
  if b[i] != 0:
    b[i] = cnt
print(b[-1]%1000000007)