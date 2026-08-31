for _ in range(int(input())):
    n=int(input())
    minn,maxx=10**10,-1
    l=[0]+list(map(int,input().split()))+[0]
    n+=1
    for i in range(1,n):
        if l[i]!=-1:
            if l[i-1]==-1 or l[i+1]==-1:
                minn=min(minn,l[i])
                maxx=max(maxx,l[i])
    if maxx==-1:
        print(0,1)
        continue
    k=(minn+maxx)//2
    maxx=0
    if l[1]==-1: l[1]=k
    for i in range(2,n):
        if l[i]==-1: l[i]=k
        maxx=max(maxx,abs(l[i]-l[i-1]))
    print(maxx,k)