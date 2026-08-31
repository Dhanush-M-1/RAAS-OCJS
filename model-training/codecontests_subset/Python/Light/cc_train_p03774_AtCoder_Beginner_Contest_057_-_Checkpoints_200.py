N,M=map(int,input().split())
s = [tuple(map(int,input().split())) for _ in range(N)]
c = [tuple(map(int,input().split())) for _ in range(M)]

def calc_dict(p1,p2):
  return abs(p1[0]-p2[0])+abs(p1[1]-p2[1])

for i in range(N):
  dist = list(map(lambda x:calc_dict(s[i],x),c))
  print(dist.index(min(dist))+1)