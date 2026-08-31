'''input
2
1 2
'''
def root(node):
    if  node==parent[node]:
        return node
    parent[node]=root(parent[node])
    return parent[node]

def union(a,b):
    root_a = root(a)
    root_b = root(b)
    if root_a!=root_b:
        if rank[root_a]<rank[root_b]:
            root_a,root_b=root_b,root_a
        parent[root_b]=root_a
        if rank[root_a]==rank[root_b]:
            rank[root_a]+=1

def find(a,b):
    if root(a)==root(b):
        return True
    else:
        return False

n=int(input())
parent=[x for x in range(n+1)]
rank=[0 for x in range(n+1)]
join=[]
remove=[]
for i in range(n-1):
    u,v=map(int,input().strip().split(' '))
    if u>v:
        u,v=v,u
    if find(u,v)==False:
        union(u,v)
    else:
        remove.append((u,v))
for i in range(1,n+1):
    parent[i]=root(parent[i]) 
for i in range(2,n+1):
    if root(1)!=root(i):
        join.append((1,i))
        union(1,i)
if len(join)==0 or len(remove)==0:
    print(0)
else:
    print(len(join))
    for i in range(len(join)):
        print(remove[i][0],remove[i][1],join[i][0],join[i][1])