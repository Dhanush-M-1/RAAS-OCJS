for _ in range(int(input())):
  l,r,d=map(int,input().split())
  if not l<=d<=r: print(d)
  else: print((r//d+1)*d)