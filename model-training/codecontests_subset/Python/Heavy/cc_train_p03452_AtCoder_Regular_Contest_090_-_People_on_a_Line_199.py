import sys
sys.setrecursionlimit(10**6)

INF=10**9
N,M=map(int,input().split())

def dfs(u,d1):
  pos_list[u]=d1
  for v,d2 in graph[u]:
    if pos_list[v]==-INF:
      dfs(v,d1+d2)
    elif pos_list[v]!=d1+d2:
      print("No")
      sys.exit(0)      
  return

graph=[]
for i in range(N+1):
  graph.append([])
for i in range(M):
  L,R,D=map(int,input().split())
  graph[L].append((R,D))
  graph[R].append((L,-D))
#print(graph)

pos_list=[-INF]*(N+1)
for i in range(1,N+1):
  if pos_list[i]!=-INF:
    continue
  dfs(i,0)
          
#print(pos_list[1:])
print("Yes")
