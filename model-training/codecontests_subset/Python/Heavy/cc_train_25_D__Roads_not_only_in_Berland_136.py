def find_set(p, a, shorten=True):
    t = a
    while p[t] != t:
        t = p[t]
    if shorten:
        p[a] = t
    return t


def union(p, a, b, acyclic):
    pa = find_set(p, a)
    pb = find_set(p, b)
    if pa != pb:
        p[pb] = pa
    elif a != b:
        acyclic.append((a, b))


n = int(input())
p = [0] * (n + 1)
ac = []
for i in range(1, n + 1):
    p[i] = i
for _ in range(n - 1):
    a, b = list(map(int, input().split()))
    union(p, a, b, ac)

print(len(ac))
j = 0
g = find_set(p, 1)
for i in range(2, n+1):
    if find_set(p, i) != g:
        union(p, 1, i, [])
        print(*ac[j], 1, i)
        j += 1
