import sys

sys.setrecursionlimit(100000)


def check(i, xs, checked):
    xi = xs[i]
    children = set()
    for j, d in links[i]:
        if checked[j]:
            continue
        if j not in xs:
            xs[j] = xi + d
        elif xi + d != xs[j]:
            return False
        children.add(j)
    checked[i] = True
    for j in children:
        if not check(j, xs, checked):
            return False
    return True


def solve():
    checked = [False] * n
    for i in range(n):
        if not checked[i]:
            xs = {}
            xs[i] = 0
            res = check(i, xs, checked)
            if not res:
                return False
            mn, mx = min(xs.values()), max(xs.values())
            if mx - mn > 1e9:
                return False
    return True


n, m = map(int, input().split())
links = [set() for _ in range(n)]
for _ in range(m):
    l, r, d = map(int, input().split())
    l -= 1
    r -= 1
    links[l].add((r, d))
    links[r].add((l, -d))
print('Yes' if solve() else 'No')
