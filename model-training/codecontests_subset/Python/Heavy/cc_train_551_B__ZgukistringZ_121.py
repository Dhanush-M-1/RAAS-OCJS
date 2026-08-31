abc = "abcdefghijklmnopqrstuvwxyz"
dabc = {a: i for i, a in enumerate(abc)}

sa = input()
sb = input()
sc = input()

def freq(s):
    d = [0] * len(abc)
    for char in s:
        d[dabc[char]] += 1
    return d

da = freq(sa)
orig = da.copy()
db = freq(sb)
dc = freq(sc)

def highest(d):
    m = len(sa)
    for i in range(0, len(abc)):
        if d[i] == 0:
            continue

        lettermax = da[i]//d[i]
        if lettermax < m:
            m = lettermax
    return m

ma = (0, 0)
limit = highest(db)
for i in range(0, limit+1):
    add = highest(dc)
    if i + add > sum(ma):
        ma = (i, add)

    for j in range(0, len(abc)):
        da[j] -= db[j]

l = [sb * ma[0]] + [sc * ma[1]]

for i in range(0, len(abc)):
    orig[i] -= db[i] * ma[0] + dc[i] * ma[1]
    l.append(abc[i] * orig[i])

print("".join(l))
