n, m = [int(x) for x in input().split()]
G = []
for i in range(n):
    G.append([])

for i in range(m):
    x,y = [int(x)-1 for x in input().split()]
    G[y].append(x)
    G[x].append(y)
Checked = [0]*n
new = 0
A = [[0]]
DA = {0:0}
B = [G[0][:]]
DB = {}
for i in G[0]:
    DB[i] = 0
    Checked[i] = 1
Checked[0] = 1
aused = 0
alastchecked = 0
bused = len(G[0])-1
blastchecked = -1
while len(DA)+len(DB) < n:
    if alastchecked < aused:
        alastchecked +=1
        for v in G[A[-1][alastchecked]]:
            if not v in DB:
                B[-1].append(v)
                DB[v] = 0
                Checked[v] = 1
                bused += 1
    elif blastchecked < bused:
        blastchecked +=1
        for v in G[B[-1][blastchecked]]:
            if not v in DA:
                A[-1].append(v)
                DA[v] = 0
                Checked[v] = 1
                aused += 1
    else:
        B.append([])
        while Checked[new] == 1:
            new += 1
        A.append([new])
        DA[new] = 0
        aused = 0
        Checked[new] = 1
        alastchecked = -1
        bused = -1
        blastchecked = -1
bad = False
for i in range(len(A)):
    aused = len(A[-i])-1
    alastchecked = -1
    bused = len(B[-i])-1
    blastchecked = -1
    while alastchecked + blastchecked < len(A[-i])+len(B[-i])-2:
        if alastchecked < aused:
                alastchecked +=1
                for v in G[A[-i][alastchecked]]:
                    if not v in DB:
                        bad = True
                    if v in DA:
                        bad = True
        if blastchecked < bused:
            blastchecked +=1
            for v in G[B[-i][blastchecked]]:
                if not v in DA:
                    bad = True
                if v in DB:
                    bad = True
if not bad:
    print(len(DA))
    for i in A:
        for j in i:
            print(j+1,end = ' ')
    print('\n'+str(len(DB)))
    for i in B:
        for j in i:
            print(j+1,end = ' ')
else:
    print(-1)