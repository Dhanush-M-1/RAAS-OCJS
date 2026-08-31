n,m = map(int,input().split())
c = n
while 1:
   if n < m:
      break
   p = n%m
   n = n//m
   c += n
   n += p
print(c)