def read_ints():
    line = input()
    return [int(e) for e in line.strip().split(' ')]

n, k = read_ints()
a = []
b = []
t = []
for _ in range(n):
    it, ia, ib = read_ints()
    if ia == 1 and ib == 1:
        t.append(it)
    elif ia == 1:
        a.append(it)
    elif ib == 1:
        b.append(it)

a.sort()
b.sort()
for i in range(min(len(a), len(b))):
    t.append(a[i] + b[i])
t.sort()

print(-1 if len(t) < k else sum(t[:k]))
