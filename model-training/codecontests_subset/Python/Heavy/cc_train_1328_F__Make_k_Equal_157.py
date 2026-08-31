from collections import defaultdict
n,k=map(int,input().split())
ar=[int(x) for x in input().split()]
ar.sort()
d={}
for i in ar:
    if(i not in d):
        d[i]=1
    else:
        d[i]+=1
bl=False
d=defaultdict(list)
for i in ar:
    count=0
    x=i
    while(x):
        d[x].append(count)
        x//=2
        count+=1

ans=1000000000
for i in d.keys():
    d[i].sort()
    for j in range(len(d[i])):
        if(j>0):
            d[i][j]+=d[i][j-1]
    if(len(d[i])>=k):
        ans=min(ans,d[i][k-1])
print(ans)
