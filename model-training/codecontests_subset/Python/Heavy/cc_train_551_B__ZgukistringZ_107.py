contest = True
if not contest:
    fin = open("in", "r")
inp = input if contest else lambda: fin.readline()[:-1]
read = lambda: tuple(map(int, inp().split()))

cstr = lambda s: dict([[v, s.count(v)] for v in set(s)])

s, a, b = inp(), inp(), inp()
ks, ka, kb = cstr(s), cstr(a), cstr(b)

def suka(ks, kx, minusV, minusK):
    ans = ""
    d = 10**10
    for k in kx:
        if not k in ks: return 0
        c = ks[k]
        if k in minusV:
            c -= minusV[k] * minusK
        d = min(max(c, 0) // kx[k], d)
    return d

da = suka(ks, ka, {}, 0)
mx = 0
ans = (-1, -1)
for dai in range(0, da+1):
    db = suka(ks, kb, ka, dai)
    if dai + db >= mx:
        ans = (dai, db)
        mx = dai + db
for k in ks:
    if k in ka: ks[k] -= ans[0] * ka[k]
    if k in kb: ks[k] -= ans[1] * kb[k]
print(ans[0] * a + ans[1] * b + "".join([str(k * ks[k]) for k in ks]))
