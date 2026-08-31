n,m = map(int,input().split(' '))
res = n

while(n >= m):
  res+= n//m
  r = n%m
  n = n//m + r

print(res)