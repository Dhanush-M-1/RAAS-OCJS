N,M=map(int,input().split())
n=[list(map(int,input().split())) for _ in range(N)]
m=[list(map(int,input().split())) for _ in range(M)]
result=[]
for i in range(len(n)):
  result=[]
  for j in range(len(m)):
    result.append(abs(n[i][0]-m[j][0])+abs(n[i][1]-m[j][1]))
  print(result.index(min(result))+1)