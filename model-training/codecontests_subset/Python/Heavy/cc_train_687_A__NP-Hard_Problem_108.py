n,m = map(int, input().split())
g={x : [] for x in range(1, n + 1)}

for item in range(m):
    u,v = map(int, input().split())
    g[v].append(u)
    g[u].append(v)

colors =  [None]*(n+1)

def inversecolor(clr):
    return [0,1][clr == 0]

def solve(g):

    paths = [x for x in g if g[x] != []]

    currentcolor = 0
    colors[paths[-1]] = currentcolor

    while paths:
        current = paths.pop()

        for targetvertex in g[current]:
            if colors[targetvertex] is None:
                colors[targetvertex] = inversecolor(colors[current])
                paths.append(targetvertex)
            else:
                if colors[targetvertex] != inversecolor(colors[current]):
                    return "-1"
    return [x for x,item in enumerate(colors) if item == 1],[x for x,item in enumerate(colors) if item == 0]


ans = solve(g)

if ans == "-1":
    print(ans)
else:
    a = ans[0]
    b = ans[1]
    print(len(a))
    print(" ".join([str(x) for x in a]))
    print(len(b))
    print(" ".join([str(x) for x in b]))

