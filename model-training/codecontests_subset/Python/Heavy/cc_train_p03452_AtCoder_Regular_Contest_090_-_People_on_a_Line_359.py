import sys
sys.setrecursionlimit(10**5)

def f(hito, zahyo):
  x[hito]=zahyo
  for tsugi in links[hito]:
    if x[tsugi[0]]==None:
      f(tsugi[0], zahyo+tsugi[1])
    else:
      if x[tsugi[0]]!=zahyo+tsugi[1]:
        print('No')
        exit()

N, M=map(int, input().split())
links=[[] for _ in range(N+1)]
for _ in range(M):
  l, r, d=map(int, input().split())
  links[l].append([r, d])
  links[r].append([l, -d])
  
x=[None]*(N+1)
for i in range(1, N+1):
  if x[i]==None:
    f(i, 0)
    
print('Yes')