
def find_set(parent,v):
    stack=[v,0]
    while stack:
        anymore=False
        x,y=stack[-2],stack[-1]
        if parent[x]!=x and y==0:
            anymore=True
            stack[-1]=1
            stack.append(parent[x])
            stack.append(0)
        elif parent[x]==x:
            dada=parent[x]
            anymore=False
        else:
            anymore=False
        if anymore==False:
            parent[x]=dada
            stack.pop()
            stack.pop()
    return parent[v]
def union_set(a,b,size,parent,brk):
    u,v=a,b
    a = find_set(parent,a)
    b = find_set(parent,b)
    if (a != b) :
        if (size[a] < size[b]):
            a,b=b,a
        parent[b] = a
        size[a] += size[b]
    else:
        brk.append([u,v])
n=int(input())
parent=[i for i in range(n+1)]
size=[1]*(n+1)
brk=[]
for i in range(n-1):
    a,b=map(int,input().split())
    union_set(a,b,size,parent,brk)
etc={}
for i in range(1,n+1):
    find_set(parent,i)
allah=parent[1]
etc[parent[1]]=1
parents=[]

for i in range(2,len(parent)):
    try:
        etc[parent[i]]+=1
    except:
        parents.append(parent[i])
        etc[parent[i]]=1
print(len(parents))
for i in range(len(parents)):
    x,y=brk.pop()
    print(x,y,allah,parents[i])