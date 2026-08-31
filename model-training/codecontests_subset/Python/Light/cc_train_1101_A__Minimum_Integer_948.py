q=int(input())
for i in range(q):
  p=input().split()
  l=int(p[0])
  r=int(p[1])
  d=int(p[2])
  if d<l:
    print(d)
  else:
    print(r+d-r%d)