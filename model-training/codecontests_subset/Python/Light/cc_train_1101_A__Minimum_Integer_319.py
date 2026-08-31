for _ in range(int(input())):
  l,r,d=map(int,input().split()); k=r%d
  if l>d:print(d)
  elif k==0:print(d+r)
  elif k>0:print(r-k+d)
 
