from sys import stdin


def input():
    return stdin.readline()[:-1]


def intput():
    return int(input())


def sinput():
    return input().split()


def intsput():
    return map(int, sinput())


# Code

t = intput()

for _ in range(t):
    n, m, a, b = intsput()
    colors = [0] * (n + 1)
    colors[a] = 'a'
    colors[b] = 'b'

    roads = {}

    for i in range(m):
        x, y = intsput()
        if x not in roads:
            roads[x] = []
        if y not in roads:
            roads[y] = []
        roads[x].append(y)
        roads[y].append(x)
    

    counts = {(True, False): 0, (True, True): 0, (False, True): 0}


    visited = set()
    while len(visited) < n - 2:
        for i in range(1, n + 1):
            if i not in (a, b) and i not in visited:
                break
        else:
            exit(1)

        start = i
        visited.add(start)
        cnt = 1
        colors[start] = 1
        adj = roads[start]
        meta, metb = False, False
        while adj:
            nxt = adj.pop()
            if nxt == a:
                meta = True
            elif nxt == b:
                metb = True
            elif nxt not in visited:
                visited.add(nxt)
                cnt += 1
                colors[nxt] = 1
                adj += roads[nxt]
        
        col1 = (meta, metb)

        counts[col1] += cnt


    print(counts[(True, False)] * counts[(False, True)])
