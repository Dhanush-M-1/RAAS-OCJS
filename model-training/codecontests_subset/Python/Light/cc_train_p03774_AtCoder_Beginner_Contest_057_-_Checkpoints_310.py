n,m = map(int,input().split())
x = [list(map(int,input().split())) for i in range(n)]
y = [list(map(int,input().split())) for i in range(m)]
for a,b in x:
  l = [abs(a-c)+abs(b-d) for c,d in y]
  print(l.index(min(l))+1)