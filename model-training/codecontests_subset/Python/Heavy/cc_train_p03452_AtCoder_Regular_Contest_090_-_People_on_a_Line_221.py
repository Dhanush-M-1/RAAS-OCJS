import sys
input = sys.stdin.readline
vs = set()
def dfs_w(d, stack):
    depth = defaultdict(int)
    pvs = set()
    while stack:
        v = stack.pop()
        vs.add(v)
        pvs.add(v)
        for u, dpd in d[v]:
            if u in pvs:
                if depth[u] != depth[v] + dpd:
                    return False
            if u in vs:
                continue
            depth[u] = depth[v] + dpd
            stack.append(u)
    return True

if __name__ == '__main__':
    from collections import defaultdict
    N, M = map(int, input().split())
    G = defaultdict(set)
    for _ in range(M):
        a, b, c = map(int, input().split())
        G[a].add((b,c))
        G[b].add((a,-c))
    for i in range(N):
        if i+1 in vs:
            continue
        stack = [i+1] 
        r =  dfs_w(G, stack)
        if not r:
            break
    if r:
        print("Yes")
    else:
        print("No")
