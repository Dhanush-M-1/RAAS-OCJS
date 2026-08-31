f=lambda x,y:abs(x[0]-y[0])+abs(x[1]-y[1])
N,M=map(int,input().split())
l=[tuple(map(int,input().split())) for _ in range(N)]
m=[tuple(map(int,input().split())) for _ in range(M)]
for i in l:
  print(min([(f(i,j),k+1) for (k,j) in enumerate(m)])[1])