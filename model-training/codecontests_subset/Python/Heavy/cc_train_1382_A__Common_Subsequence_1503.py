t=int(input())
for i in range(0,t):
  c=[]
  n,m = map(int,input().split())
  a = list(map(int,input().split()))
  b = list(map(int,input().split()))
  #if a is larger
  if n>=m:
    for j in range(0,m):
      if b[j] in a:
        a = a[a.index(b[j]):]
        c.append(b[j])
        break
      
  #if b is larger
  elif n<=m:
    for j in range(0,n):
      if a[j] in b:
        c.append(a[j])
        b = b[b.index(a[j]):]
        break

  if len(c)!=0:
    print("YES")
    print(len(c), *c)
  elif len(c)==0:
    print("NO")