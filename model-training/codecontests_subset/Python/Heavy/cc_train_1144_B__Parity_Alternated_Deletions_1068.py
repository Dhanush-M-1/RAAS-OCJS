a = int(input())
b = input()
p = b.split()
for i in range(len(p)):
    p[i] = int(p[i])
ch = 0
nch = 0
sch = 0
snch = 0
k = []
l = []
for i in range(len(p)):
    if p[i] % 2 == 0:
        ch = ch + 1
        sch = sch + p[i]
        k.append(p[i])
    elif p[i] % 2 == 1:
        nch = nch + 1
        snch = snch + p[i]
        l.append(p[i])
if abs(ch - nch)  == 0:
    print(0)
else:
    if ch > nch:
        o = 0
        m = abs(ch - nch)
        while m != 1:
            o = o + min(k)
            k.remove(min(k))
            m = m - 1
    else:
        o = 0
        m = abs(ch - nch)
        while m != 1:
            o = o + min(l)
            l.remove(min(l))
            m = m - 1
    print(o)
