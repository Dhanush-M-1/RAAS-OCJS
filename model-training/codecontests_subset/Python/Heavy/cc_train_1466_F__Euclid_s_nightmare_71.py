import sys
input = sys.stdin.readline
mod=10**9+7

n,m=map(int,input().split())

Group = [i for i in range(m+1)]
GroupOne = [0]*(m+1)

Nodes = [1]*(m+1)

def find(x):
    while Group[x] != x:
        x=Group[x]
    return x

def Union(x,y):
    if find(x) != find(y):
        if Nodes[find(x)] < Nodes[find(y)]:
            
            Nodes[find(y)] += Nodes[find(x)]
            Nodes[find(x)] = 0

            if GroupOne[find(x)]==1 or GroupOne[find(y)]==1:
                GroupOne[find(x)]=1
                GroupOne[find(y)]=1
                
            Group[find(x)] = find(y)
      
        else:
            Nodes[find(x)] += Nodes[find(y)]
            Nodes[find(y)] = 0

            if GroupOne[find(x)]==1 or GroupOne[find(y)]==1:
                GroupOne[find(x)]=1
                GroupOne[find(y)]=1
                
            Group[find(y)] = find(x)


ANS=[]
for i in range(n):
    V=tuple(map(int,input().split()))

    if V[0]==1:
        x=V[1]
        if GroupOne[find(x)]==0:
            ANS.append(i+1)
            GroupOne[find(x)]=1
        else:
            continue

    else:
        x,y=V[1],V[2]
        if find(x)==find(y) or (GroupOne[find(x)]==1 and GroupOne[find(y)]==1):
            continue
        else:
            Union(x,y)
            ANS.append(i+1)

print(pow(2,len(ANS),mod),len(ANS))
print(*ANS)
        
