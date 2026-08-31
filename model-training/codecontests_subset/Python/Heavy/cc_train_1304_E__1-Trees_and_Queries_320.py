from sys import stdin, stdout
import math

graph = []
lca = []
depth = []
lim = 0

def build_lca(cur, p):
    global lca
    global depth
    global lim
    global graph
    stack = []
    stack.append((cur,p))
    while stack:
        cur,p = stack.pop()
        lca[cur][0] = p
        depth[cur] = depth[p] + 1
        for i in range(1, lim):
            lca[cur][i] = lca[lca[cur][i-1]][i-1]
            
        for i in graph[cur]:
            if i == p:
                continue
            stack.append((i,cur))
            
def get_lca(a,b):
    global lim
    global graph
    global lca
    global depth
    
    lg = 0
    if depth[a] > depth[b]:
        a,b = b,a
    for i in range(lim,-1,-1):
        if depth[lca[b][i]] >= depth[a]:
            b = lca[b][i]
            lg += int(pow(2,i))

    if b == a:
        return lg
    for i in range(lim,-1,-1):
        if lca[b][i] != lca[a][i]:
            b = lca[b][i]
            a = lca[a][i]
            lg += int(pow(2,i+1))
    return lg +2
    

def main():
    global graph
    global lca
    global depth
    global lim
    n = int(stdin.readline())
    lim =int(math.log(n,2))+1
    graph = [set() for _ in range(n+1)]
    lca = [[0 for _ in range(lim+1)] for _ in range(n+1)]
    depth = [0 for _ in range(n+1)]
    
    for _ in range (n-1):
        a,b = list(map(int, stdin.readline().split()))
        graph[a].add(b)
        graph[b].add(a)
    build_lca(1,0)
    q = int(stdin.readline())
    for _ in range(q):
        x,y,a,b,k = list(map(int, stdin.readline().split()))
        ans = -1
        temp = get_lca(a,b)
        if temp % 2 == k % 2 and k >= temp:
            stdout.write("YES\n")
            continue
        temp = min(get_lca(x,a) + get_lca(y,b), get_lca(x,b) + get_lca(y,a)) + 1
        if temp % 2 == k % 2 and k >= temp:
            stdout.write("YES\n")
            continue
        stdout.write("NO\n")
        
main()
        