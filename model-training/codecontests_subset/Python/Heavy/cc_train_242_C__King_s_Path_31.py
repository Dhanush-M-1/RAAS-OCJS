from collections import deque

def bfs(x0,y0,x1,y1,dic):
    visited={}
    x=[1,-1,0,0,-1,-1,1,1]
    y=[0,0,-1,1,1,-1,1,-1]
    q=deque()
    q.append((x0,y0,0))
    visited[(x0,y0)]=1
    while(q!=deque([])):
        a=q.popleft()
        for i in range(8):
            if (a[0]+x[i],a[1]+y[i]) in dic and (a[0]+x[i],a[1]+y[i]) not in visited:
                visited[(a[0]+x[i],a[1]+y[i])]=1
                q.append((a[0]+x[i],a[1]+y[i],a[2]+1))
                if (a[0]+x[i],a[1]+y[i])==(x1,y1):
                    return [True,a[2]+1]
    return [False]

x0,y0,x1,y1=map(int,input().split())
n=int(input())
dic={}
for i in range(n):
    arr=[int(i) for i in input().split()]
    i=arr[0]
    for j in range(arr[1],arr[2]+1):
        if (i,j) not in dic:
            dic[(i,j)]=1
res=bfs(x0,y0,x1,y1,dic)
if res[0]:
    print(res[1])
else:
    print(-1)
