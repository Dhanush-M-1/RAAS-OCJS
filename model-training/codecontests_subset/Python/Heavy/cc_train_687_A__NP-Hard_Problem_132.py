n,m=map(int,input().split())

g=[[] for i in range(n)]

for i in range(m):
    u,v=map(int,input().split())
    u-=1;v-=1
    g[u].append(v)
    g[v].append(u)

used=[-1]*n
ok=True
w=[[],[]]

def bfs(start,color):
    used[start]=color
    w[color].append(start)
    q=[start]
    while q!=[]:
        for u in g[q[0]]:
            if used[u]==-1:
                used[u]=(1+used[q[0]])%2
                w[used[u]].append(u)
                q.append(u)
            else:
                if used[u]==(used[q[0]]+1)%2:
                    pass
                else:
                    return False
        q.pop(0)
    return True

for i in range(n):
    if used[i]==-1:
        if not bfs(i,0):
            ok=False
            break
if ok:
    for i in range(2):
        print(len(w[i]))
        for j in w[i]:
            print(j+1,end=" ")
        print()
else:
    print(-1)

