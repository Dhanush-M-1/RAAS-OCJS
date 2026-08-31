N,M=map(int,input().split())
n=[]
m=[]
for i in range(N):
  n.append(list(map(int,input().split())))
for l in range(M):
  m.append(list(map(int,input().split())))
L=[]
for i in n:
  M=[]
  for l in m:
    A=abs(i[0]-l[0])+abs(i[1]-l[1])
    M.append(A)
  print(M.index(min(M))+1)