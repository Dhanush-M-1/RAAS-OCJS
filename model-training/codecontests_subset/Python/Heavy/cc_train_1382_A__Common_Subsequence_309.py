t=int(input())
for i in range(t):
  c=1
  n,k=map(int,input().split())
  a=list(map(int,input().split()))
  b=list(map(int,input().split()))
  l=max(n,k)
  res=0
  if n<k:
    for i in range(n):
      if a[i] in b:
        c=0
        res=a[i]
        break  
  elif n>k:
    for i in range(k):
      if b[i] in a:
        c=0
        res=b[i]
        break
  elif n==k:
    for i in range(n):
      if a[i] in b:
        c=0
        res=a[i]
        break
  if c==0:
    print("YES")
    print(1,res)
  else:
    print("NO")