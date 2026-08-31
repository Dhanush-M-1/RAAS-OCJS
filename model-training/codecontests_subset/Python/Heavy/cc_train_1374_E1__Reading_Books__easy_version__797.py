n, k = map(int, input().split())
cnta = []
cntb = []
cntab = []
for i in range(n):
    t, a, b = map(int, input().split())
    if a:
        if b:
            cntab.append(t)
        else:
            cnta.append(t)
    elif b:
        cntb.append(t)
T = 0
cnta = sorted(cnta)
cntb = sorted(cntb)
cntab = sorted(cntab)
l, m = 0, 0
r = min(len(cnta), len(cntb))
it = 0
while (l < r) and (it < k):
    if (m >= len(cntab)) or (cnta[l] + cntb[l] < cntab[m]):
        T += cnta[l] + cntb[l]
        l += 1
    else:
        T += cntab[m]
        m += 1
    it += 1
if (it + len(cntab) - m < k):
    print(-1)
else:
    print(T + sum(cntab[m:m + k - it]))
        
    
