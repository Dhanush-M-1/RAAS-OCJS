l=input().split()
print(*l)
n=int(input())
for i in range(n):
  m,n=input().split()
  l[l.index(m)]=n
  print(*l)