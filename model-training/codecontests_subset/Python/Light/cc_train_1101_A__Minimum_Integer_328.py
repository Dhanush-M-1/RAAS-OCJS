for _ in range(int(input())):
 l,r,d=map(int,input().split())
 if d<l:
  print(d)
 if d>=l and d<=r:
  print(((r//d)+1)*d)
 if d>r:
  print(d)