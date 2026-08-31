def find_set(v):
    if parent[v]==v:
        return v
    parent[v]=find_set(parent[v])
    return parent[v]

def union(a,b):
    a=find_set(a)
    b=find_set(b)
    if a!=b:
        if size[a]<size[b]:
            a,b=b,a
        parent[b]=a
        size[a]+=size[b]
        return 1
    return 0

n=int(input())
parent=[int(i) for i in range(n+1)]
size=[1 for i in range(n+1)]
broke=[]
for i in range(1,n):
    a,b=map(int,input().split())
    x=union(a,b)
    if x==0:
        broke.append((a,b))

print(len(broke))
free=[]
for i in range(1,n+1):
    if parent[i]==i:
        free.append(i)
if len(broke)!=0:
    Ans=""
    for i in range(len(broke)):
        Ans+=str(broke[i][0])+" "+str(broke[i][1])+" "+str(free[i])+ " "+str(free[i+1])+" "
    print(Ans)