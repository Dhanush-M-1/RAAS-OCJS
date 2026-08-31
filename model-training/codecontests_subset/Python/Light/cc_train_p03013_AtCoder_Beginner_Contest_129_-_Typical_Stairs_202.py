n, m = map(int, input().split())
a = [int(input()) for i in range(m)]
a = set(a)
d = [1] + [1]*n
for i in range(1, n):
  if i in a:
    d[i] = 0
    d[i+1] = d[i-1]
  else:
    d[i+1] = d[i] + d[i-1]
    
print(d[n]%1000000007)