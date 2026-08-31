t=int(input())
for i in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    adj=[]
    ans=0
    k=-1
    for j in range(n-1):
        if a[j]==-1:
            if a[j+1]!=-1:
                adj.append(a[j+1])
        else:
            if a[j+1]==-1:
                adj.append(a[j])
            else:
                if abs(a[j]-a[j+1])>ans:ans=abs(a[j]-a[j+1])
    if adj==[]:print(ans,0);continue
    adj.sort()
    if ans < adj[-1]-(adj[-1]+adj[0])//2:ans=adj[-1]-(adj[0]+adj[-1])//2
    print(ans,(adj[-1]+adj[0])//2)