import sys
INF=10**9
N,M=map(int,input().split())

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
    
  queue={i}
  pos_list[i]=0
  while(len(queue)>0):
    new_queue=set()
    for q in queue:
      for v,d in graph[q]:
        if pos_list[v]==-INF:
          pos_list[v]=pos_list[q]+d
          new_queue.add(v)
        elif pos_list[v]!=pos_list[q]+d:
          print("No")
          sys.exit(0)
          
    queue=new_queue
          
#print(pos_list[1:])
print("Yes")