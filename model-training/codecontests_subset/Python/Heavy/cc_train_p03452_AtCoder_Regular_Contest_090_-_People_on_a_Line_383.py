def check(si, checked):
    xs = {si: 0}
    q = {si}
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
            q.add(j)
        checked[i] = True
    return True


def solve():
    checked = [False] * n
    return all(checked[i] or check(i, checked) for i in range(n))


n, m = map(int, input().split())
links = [set() for _ in range(n)]
for _ in range(m):
    l, r, d = map(int, input().split())
    l -= 1
    r -= 1
    links[l].add((r, d))
    links[r].add((l, -d))
print('Yes' if solve() else 'No')
