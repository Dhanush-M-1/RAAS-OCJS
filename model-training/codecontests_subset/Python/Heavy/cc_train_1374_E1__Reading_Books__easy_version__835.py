line = input()
n, m, k = [int(i) for i in line.split(' ')]
books, allL, aliceL, bobL, other =list(range(1, n + 1)), [], [], [], []
ts = [[] for _ in range(n + 1)] 
for i in range(n):
    line = input()
    t, a, b = [int(j) for j in line.split(' ')]
    ts[i + 1] = [t, a, b]
    if a == 1 and b == 1:
        allL.append(i + 1)
    elif a == 1:
        aliceL.append(i + 1)
    elif b == 1:
        bobL.append(i + 1)
    else:
        other.append(i + 1)

if len(allL) + min(len(aliceL), len(bobL)) < k or (len(allL) < k and 2 * (k - len(allL)) > m - len(allL)) :
    print(-1)
    exit()

books.sort(key=lambda x: (ts[x][0], -ts[x][2]*ts[x][1]))
allL.sort(key=lambda x: (ts[x][0], -ts[x][2]*ts[x][1]))
aliceL.sort(key=lambda x: (ts[x][0], -ts[x][2]*ts[x][1]))
bobL.sort(key=lambda x: (ts[x][0], -ts[x][2]*ts[x][1]))
other.sort(key=lambda x: (ts[x][0], -ts[x][2]*ts[x][1]))
x = max(2 * k - m, 0, k - min(len(aliceL), len(bobL)), m - len(aliceL) - len(bobL) - len(other))
cura, curb, curo, cur = max(0, k - x), max(0, k - x), 0, sum(ts[i][0] for i in allL[:x]) 
cur += sum(ts[i][0] for i in aliceL[:cura]) + sum(ts[i][0] for i in bobL[:curb])
while cura + x + curb + curo < m:
    an = ts[aliceL[cura]][0] if cura < len(aliceL) else 9999999999
    bn = ts[bobL[curb]][0] if curb < len(bobL) else 9999999999
    on = ts[other[curo]][0] if curo < len(other) else 9999999999
    cur += min(an, bn, on)
    if an <= bn and an <= on:
        cura += 1
    elif bn <= an and bn <= on:
        curb += 1
    else:
        curo += 1      
res, a, b, o = cur, cura, curb, curo
for i in range(x + 1, len(allL) + 1):  #都喜欢的长度
    cur += ts[allL[i - 1]][0]
    if cura > 0:
        cura -= 1
        cur -= ts[aliceL[cura]][0]
    if curb > 0:
        curb -= 1
        cur -= ts[bobL[curb]][0]
    if curo > 0:
        curo -= 1
        cur -= ts[other[curo]][0]
    while cura + i + curb + curo < m:
        an = ts[aliceL[cura]][0] if cura < len(aliceL) else 9999999999
        bn = ts[bobL[curb]][0] if curb < len(bobL) else 9999999999
        on = ts[other[curo]][0] if curo < len(other) else 9999999999
        cur += min(an, bn, on)
        if an <= bn and an <= on:
            cura += 1
        elif bn <= an and bn <= on:
            curb += 1
        else:
            curo += 1
    if res > cur:
        res,x, a, b, o = cur,i, cura, curb, curo
    else:
        break
print(res)
for i in range(x):
    print(allL[i], end=' ')
for i in range(a):
    print(aliceL[i], end = ' ')
for i in range(b):
    print(bobL[i], end = ' ')
for i in range(o):
    print(other[i], end = ' ')
 

    
    



    









