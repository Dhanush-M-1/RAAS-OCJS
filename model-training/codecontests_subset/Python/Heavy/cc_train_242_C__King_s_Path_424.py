from collections import deque

def neighs(x0, x1):
    return [(x0, x1 + 1),
            (x0 + 1, x1 + 1),
            (x0 + 1, x1),
            (x0 + 1, x1 - 1),
            (x0, x1 - 1),
            (x0 - 1, x1 - 1),
            (x0 - 1, x1),
            (x0 - 1, x1 + 1)]
            

def bfs(x0, x1, y0, y1, allowed):
    fifo = deque([(x0, x1, 0)])
    while fifo:
        x0, x1, d = fifo.pop()
        for n0, n1 in neighs(x0, x1):
            if (n0, n1) in allowed:
                allowed.remove((n0, n1))
                fifo.appendleft((n0, n1, d + 1))
        if (x0, x1) == (y0, y1):
            return d
    return -1

def solve():
    x0, x1, y0, y1 = map(int, input().split())
    n = int(input())
    allowed = set()
    for _ in range(n):
        r, a, b = map(int, input().split())
        for c in range(a, b+1):
            allowed.add((r, c))
    val = bfs(x0, x1, y0, y1, allowed)
    print(val)


if __name__ == '__main__':
    solve()
