n,m=map(int,input().split())
a=[[int(i) for i in input().split()] for j in range(n)]
c=[[int(i) for i in input().split()] for j in range(m)]
for x1,y1 in a:
  d=10**9
  n=1
  s=0
  for x2,y2 in c:
    if abs(x1-x2)+abs(y1-y2)<d:
      s=n
      d=abs(x1-x2)+abs(y1-y2)
    n+=1
  print(s)