a,b=map(int, input().split())
x=set()
for i in range(a):
  c=list(map(int, input().split()))
  c.remove(c[0])
  x. update(c)
if len(x)==b:
  print("YES")
else:
  print("NO")