alpha = "abcdefghijklmnopqrstuvwxyz"
dict_alpha = {j: i for i, j in enumerate(alpha)}

def freq(s):
    d = [0] * len(alpha)
    for c in s:
        d[dict_alpha[c]] += 1
    return d

sa = input()
sb = input()
sc = input()

cntA = freq(sa)
cpy_cntA = cntA.copy()
cntB = freq(sb)
cntC = freq(sc)

def highest(d):
    m = len(sa)
    for i in range(26):
        if d[i] == 0:
            continue
        m = min(m, cntA[i]//d[i])
    return m

m = (0, 0)
n = highest(cntB)
for i in range(n+1):
    add = highest(cntC)
    if i + add > sum(m):
        m = (i, add)
    for j in range(26):
        cntA[j] -= cntB[j]

res = [sb * m[0]] + [sc * m[1]]
for i in range(26):
    cpy_cntA[i] -= cntB[i] * m[0] + cntC[i] * m[1]
    res.append(alpha[i] * cpy_cntA[i])
print("".join(res))
