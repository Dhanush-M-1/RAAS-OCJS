def an(x):
    for i in x:
        return i
    return None

n = int(input())
# 1 2 .. n
r = dict()
for i in range(1, n+1):
    r[i] = set()
edge = set()
for i in range(n-1):
    (a, b) = map(int, input().split())
    edge.add((min(a,b),max(a,b)))
    r[a].add(b)
    r[b].add(a)

total = set(range(1, n+1))
v = []
while len(total) > 0:
    v.append(set())
    x = total.pop()
    v[-1].add(x)
    sosed = set()
    sosed.add(x)
    while len(sosed) > 0:
        sosed2 = set()
        for i in sosed:
            for j in r[i]:
                if j in total:
                    sosed2.add(j)
                    v[-1].add(j)
                    total.discard(j)
        sosed = sosed2.copy()


need = set()
for z in v:
    if len(z) == 1:
        continue
    x = an(z)
    sosed = set()
    sosed.add(x)
    pos = set()
    pos.add(x)
    while len(sosed) > 0:
        sosed2 = set()
        for i in sosed:
            for j in r[i]:
                if j not in pos:
                    need.add((min(i,j),max(i,j)))
                    sosed2.add(j)
                    pos.add(j)

        sosed = sosed2.copy()

print(len(v)-1)
edge -= need
edge = list(edge)
for i in range(len(v)-1):
    print(edge[i][0],edge[i][1],an(v[i]), an(v[i+1]))