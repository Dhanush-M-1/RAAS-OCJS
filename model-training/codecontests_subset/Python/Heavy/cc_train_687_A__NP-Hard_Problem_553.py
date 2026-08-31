from collections import defaultdict

def dfs(g,n,visited,co,col):
    stack = [] 
    stack.append(n)  
    while (len(stack)):  
        s = stack[-1]  
        stack.pop()
        col = col%2 + 1 
        if (s not in visited):  
            visited.add(s)
        for node in g[s]:
            if(node in visited and co[s] == co[node]):
                print(-1)
                exit(0)
            if (node not in visited):  
                stack.append(node)
                if(co[s]==1):
                    co[node] = 2
                elif(co[s]==2):
                    co[node] = 1 

def DFS(g,n):
    visited = set()
    co = {i:0 for i in range(1,n+1)}
    for i in range(1,n+1):
        if(i not in visited):
            co[i] = 1
            dfs(g,i,visited,co,0)
    return co

visited = set()
n,m = map(int,input().split())
g = defaultdict(list)
for _ in range(m):
    x,y = map(int,input().split())
    g[x].append(y)
    g[y].append(x)
    
co = DFS(g,n)
o,e = [],[]
for k in co:
    if(co[k]==2):e.append(k)
    if(co[k]==1):o.append(k)
print(len(o))
print(*o)
print(len(e))
print(*e)
