n,m=map(int,input().split())
L1,L2,L3=[],[],[]
for s in range(n):
  L1.append(list(map(int,input().split())))
for s in range(m):
  L2.append(list(map(int,input().split())))
for x in L1:
  L3=[]
  for y in L2:
    L3.append(abs(x[0]-y[0])+abs(x[1]-y[1]))
  print(L3.index(min(L3))+1)