N,M = map(int,input().split())
S = [list(map(int,input().split())) for n in range(N)]
P = [list(map(int,input().split())) for m in range(M)]

for a,b in S:
  D = []
  for c,d in P:
    D.append(abs(a-c)+abs(b-d))
  print(1+D.index(min(D)))