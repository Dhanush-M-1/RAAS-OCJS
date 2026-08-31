n,m=map(int,input().split())
A = [list(map(int,input().split())) for _ in range(n)]
C = [list(map(int,input().split())) for _ in range(m)]
for a,b in A:
  l=[abs(a-c)+abs(b-d) for c,d in C]
  print(l.index(min(l))+1)