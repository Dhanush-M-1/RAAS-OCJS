t=int(input())
for s in range(t):
    n,m=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    visited=[0 for i in range(1001)]
    visit=[0 for i in range(1001)]
    for i in range(n):
        visited[a[i]]+=1
    for i in range(m):
        visit[b[i]]+=1
    flag=0
    for i in range(1001):
        if(visited[i]!=0 and visit[i]!=0):
            flag=1
            break
    if(flag==1):
        print("YES")
        print(1,i)
    else:
        print("NO")