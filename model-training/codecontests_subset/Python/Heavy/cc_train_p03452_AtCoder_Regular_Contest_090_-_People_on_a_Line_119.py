def solve(N, M, lrd):
    edges = {}
    nodes = {}
    for l, r, d in lrd:
        if not l in edges:
            edges[l] = {}
        if not r in edges:
            edges[r] = {}
        edges[l][r] = d
        edges[r][l] = -d
        nodes[l] = None
        nodes[r] = None
    for node in nodes:
        if nodes[node] is not None:
            continue
        nodes[node] = 0
        stack = []
        stack.append(node)
        while stack:
            node = stack.pop()
            for n, d in edges[node].items():
                if nodes[n] is None:
                    stack.append(n)
                    nodes[n] = nodes[node] + edges[node][n]
                else:
                    if nodes[n] != nodes[node] + edges[node][n]:
                        return False
    return True

if __name__ == "__main__":
    N, M = [int(x) for x in input().split()]
    lrd = []
    for i in range(M):
        lrd.append([int(x) for x in input().split()])
    if solve(N, M, lrd):
        print("Yes")
    else:
        print("No")
