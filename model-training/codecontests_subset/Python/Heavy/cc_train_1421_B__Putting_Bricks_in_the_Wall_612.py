from collections import deque as dq
import sys
input=sys.stdin.readline
t=int(input())
while t:
    n=int(input())
    ll=[]
    for i in range(n):
        s=input().split()[0]
        ll.append(s)
    a=ll[0][1]
    b=ll[1][0]
    c=ll[n-1][n-2]
    d=ll[n-2][n-1]
    ans=[]
    if(a==b and c==d):
        if(a==c):
            ans.append((1,2))
            ans.append((2,1))
        else:
            lol=1
    elif(a==b and c!=d):
        if(a==c):
            ans.append((n,n-1))
        else:
            ans.append((n-1,n))
    elif(a!=b and c==d):
        if(a==c):
            ans.append((1,2))
        else:
            ans.append((2,1))
    else:
        if(a=='1'):
           ans.append((1,2))
        else:
            ans.append((2,1))
        if(c=='0'):
            ans.append((n,n-1))
        else:
            ans.append((n-1,n))
    print(len(ans))
    for i in ans:
        print(*i)
    t-=1
        
        
    '''
    val=ll[0][1]
    q=dq([(0,1)])
    vis=[[0]*n for i in range(n)]
    X=[0,1,0,-1]
    Y=[1,0,-1,0]
    while q:
        x,y=q.pop()
        vis[x][y]=1
        for i in range(4):
            cx=x+X[i]
            cy=y+Y[i]
            if(cx>=0 and cx<n and cy>=0 and cy<n and ll[cx][cy]==ll[x][y] and vis[cx][xy]==0):
                q.append((cx,cy))
                vis[cx][cy]=1
    '''