
a = input().rstrip()
b = input().rstrip()
c = input().rstrip()
d = {}
d1 = {}
d2 = {}
db = {}
dc = {}
sb = set()
sc = set()
s = set()
for i in range(len(a)):
    if a[i] not in s:
        s.add(a[i])
        d[a[i]] = 1
        d1[a[i]] = 1
        d2[a[i]] = 1
    else:
        d[a[i]] += 1
        d1[a[i]] += 1
        d2[a[i]] += 1

for i in range(len(b)):
    if b[i] not in sb:
        sb.add(b[i])
        db[b[i]] = 1
    else:
        db[b[i]] += 1

for i in range(len(c)):
    if c[i] not in sc:
        sc.add(c[i])
        dc[c[i]] = 1
    else:
        dc[c[i]] += 1
maxib = 10**6
maxic = 10**6
for i in range(len(b)):
    if b[i] in s:
        maxib = min(maxib, d[b[i]]//db[b[i]])
    else:
        maxib = 0
        break

for i in range(len(c)):
    if c[i] in s:
        maxic = min(maxic, d[c[i]]//dc[c[i]])
    else:
        maxic = 0
        break
ans = -1
lol = 0
pop = 0
for i in range(maxib + 1):
    minb = i
    for key, value in db.items():
        if key in s:
            d[key] -= i*value
    minc = 10**6
    for key, value in dc.items():
        if key in s:
            if d[key]//dc[key] < minc:
                minc = d[key]//dc[key]
        else:
            minc = 0
    if minc + minb > ans:
        ans = minc + minb
        lol = minc
        pop = minb
    for key, value in db.items():
        if key in s:
            d[key] += i*value 

for i in range(lol):
    print(c, end = '')
for i in range(pop):
    print(b, end = '')

for i in c:
    if i in s:
        d[i] -= lol
for i in b:
    if i in s:
        d[i] -= pop

for i,j in d.items():
    print(i*j, end = '')
                    
            
            
    
    
        

