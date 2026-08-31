n,m = map(int,input().split())
s = [list(map(int,input().split())) for i in range(n)]
c = [list(map(int,input().split())) for i in range(m)]
for a in s:
  l = [abs(a[0]-b[0])+abs(a[1]-b[1]) for b in c]
  print(l.index(min(l))+1)
