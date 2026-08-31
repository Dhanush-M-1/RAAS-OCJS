def abhi(node):

    visited[node]=1
    color[node]=1

    q=[node]

    while q:

        a=q.pop(0)

        for j in adj[a]:
            if visited[j]==0:
                if color[a]==1:color[j]=2
                elif color[a]==2:color[j]=1
                
                q.append(j)
                visited[j]=1
            else:
                if color[j]==color[a]:
                
                    print(-1)
                    exit(0)


                



import sys
input= sys.stdin.readline


n,q = map(int,input().split())



adj=[[] for j in range(n+1)]

for i in range(q):
    a,b = map(int,input().split())


    adj[a].append(b)
    adj[b].append(a)



visited =[0]*(n+1)
color =[0]*(n+1)



for j in range(1,n+1):
    if visited[j]==0:
        abhi(j)
    else:
        continue

one =[]
two=[]
u=True

if u==True:
    for j in range(n+1):
        if visited[j]==1:
            if color[j]==1:one.append(j)
            elif color[j]==2:two.append(j)
   

  
    print(len(one))
    print(*one)
    print(len(two))
    print(*two)
else:
    print(-1)
