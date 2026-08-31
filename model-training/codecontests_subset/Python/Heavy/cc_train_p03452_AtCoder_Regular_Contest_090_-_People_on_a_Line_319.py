def check(si, xs, checked):
    q = [si]
    while q:
        i = q.pop()
        xi = xs[i]
        for j, d in links[i]:
            if checked[j]:
                continue
            if j not in xs:
                xs[j] = xi + d
            elif xi + d != xs[j]:
                return False
            q.append(j)
        checked[i] = True
    return True


def solve():
    checked = [False] * n
    for i in range(n):
        if not checked[i]:
            xs = {}
            xs[i] = 0
            if not check(i, xs, checked):
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
