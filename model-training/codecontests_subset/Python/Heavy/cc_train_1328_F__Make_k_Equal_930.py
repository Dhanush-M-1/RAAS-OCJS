from math import inf
nk = input().split()
n = int(nk[0])
k = int(nk[1])

a = [int(ai) for ai in input().split()]

possibilities = []
for ai in a:
    moves = 0
    while ai != 0:
        possibilities.append((ai,  moves))
        ai = ai // 2
        moves += 1
    possibilities.append((ai, moves))
possibilities.sort()

i = 0
minOps = inf
while i < len(possibilities):
    same = possibilities[i][0]
    sameElems = 0
    operations = 0
    j = i
    while(j < len(possibilities) and possibilities[j][0] == same):
        sameElems += 1
        operations += possibilities[j][1]
        if sameElems == k:
            break
        j += 1
    if sameElems == k and operations < minOps:
        minOps = operations
    j = i
    while(j < len(possibilities) and possibilities[j][0] == same):
        j += 1
    i = j
print(minOps)
