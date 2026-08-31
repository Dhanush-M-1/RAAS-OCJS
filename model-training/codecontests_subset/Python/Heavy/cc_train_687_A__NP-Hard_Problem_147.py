import sys
sys.setrecursionlimit(10**6)

debug_mode = True if len(sys.argv) > 1 and sys.argv[1] == "-d" else False
if debug_mode:
    import os
    infile = open(os.path.abspath(__file__).replace(".py", ".in"))

    def input():
        return infile.readline()


# ==============================================================

from collections import defaultdict, deque


def main():
    n_vertices, m_edges = list(map(int, input().strip().split()))
    G, C = defaultdict(list), []  # Graph, Components
    for _ in range(m_edges):
        u, v = list(map(int, input().strip().split()))
        G[u].append(v)
        G[v].append(u)

    S, X, Y = set(), set(), set()  # visited, red, blue
    R, B = 0, 1
    for u in G:
        if u in S:
            # already visited the connected component of this node
            continue

        else:
            # new component, unvisited node
            # check for bipartiteness
            Q = deque()
            Q.append((u, R))
            while Q:
                curr, color = Q.popleft()
                if curr not in S:
                    # unvisited node
                    S.add(curr)
                    if color == R:
                        X.add(curr)
                    else:
                        Y.add(curr)

                    next_color = R if color == B else B
                    for v in G[curr]:
                        Q.append((v, next_color))

                else:
                    # node was already visited, check feasibility
                    if curr in X and color != R:
                        print(-1)
                        return
                    if curr in Y and color != B:
                        print(-1)
                        return

    XL = list(X)
    print(len(XL))
    print(" ".join(str(x) for x in XL))
    YL = list(Y)
    print(len(YL))
    print(" ".join(str(y) for y in YL))


main()

# ==============================================================

if debug_mode:
    infile.close()
