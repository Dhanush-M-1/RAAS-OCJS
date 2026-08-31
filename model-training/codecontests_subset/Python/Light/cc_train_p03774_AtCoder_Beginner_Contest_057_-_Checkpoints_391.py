N,M=map(int,input().split())
ab=[]
for i in range(N):
  ab.append(list(map(int,input().split())))
cd=[]
for i in range(M):
  cd.append(list(map(int,input().split())))
for i in ab:
  l=[]
  for j in cd:
    l.append(abs(i[0]-j[0])+abs(i[1]-j[1])) 
  print(l.index(min(l))+1)  