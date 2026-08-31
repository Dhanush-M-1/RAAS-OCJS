
graph = {}
def solve(x):
    if not x : 
        return 0
    root = max(x) 
    i = x.index(root)
    left = solve(x[:i])
    right = solve(x[i+1 :])
    graph[root] = [left, right]
    return root

def dfs(graph, node, visited =  None, h =0, depth = None,):
    if visited == None:
        visited = set()
        depth = {}
    visited.add(node)
    depth[node] = h
    for n in set(graph[node])- visited:
        if n == 0:
            continue
        dfs(graph, n, visited, h+1, depth)
    return depth    
def aff (x, depth):
    for a in x:
        print(depth[a], end = " ")
    

    

if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        n = int(input())
        x = list(map(int, input().split()))
        solve(x)
        depth = dfs(graph, max(x))
        aff(x, depth)
        print("")

        

