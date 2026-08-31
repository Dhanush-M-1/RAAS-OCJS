vs = set()
from collections import defaultdict
def dfs_w(d, stack):
    depthh = defaultdict(int)
    path = [0]
    pvs = set()
    if stack[0] in vs:
        return True
    while stack:
        v, dpd = stack.pop()
        if v > 0:
            parent = path[-1]
            path.append(v)
            vs.add(v)
            pvs.add(v)
            depthh[v] = depthh[parent] + dpd

            for u, dpd in d[v]:
                if u in pvs:
                    if depthh[u] != depthh[v] + dpd:
                        return False
                if u in vs:
                    continue
                stack += [(-v, dpd), (u, dpd)]
        else:
            path.pop()

    return True
#    return S, F, depth, depthh

if __name__ == '__main__':
    N, M = map(int, input().split())
    G = [set() for _ in range(N+1)]
    for _ in range(M):
        a, b, c = map(int, input().split())
        G[a].add((b,c))
        G[b].add((a,-c))
    for i in range(N):
        if i in vs:
            continue
        stack = [(i+1, 0)] 
        r =  dfs_w(G, stack)
        if not r:
            break
    if r:
        print("Yes")
    else:
        print("No")
