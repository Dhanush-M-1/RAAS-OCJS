t=int(input())
while t:
    t-=1
    n,m=map(int,input().split())
    s=list(input())
    ar=list(map(int,input().split()))
    alpha=['a','b','c','d','e','f','g','h','i','j','k','l','m','n',
    'o','p','q','r','s','t','u','v','w','x','y','z',]

    visited=[0]*n
    for i in ar:
        visited[i-1]+=1
    
    # print(visited)
    
    curr=0
    for i in range(len(visited)-1,-1,-1):
        visited[i]+=curr
        curr=max(curr,visited[i])

    d={}
    for i in range(len(s)):
        try:
            d[s[i]]+=visited[i]+1
        except:
            d[s[i]]=visited[i]+1

    for i in alpha:
        try:
            print(d[i],end=' ')
        except:
            print(0,end=' ')
    
    print()

    
    
