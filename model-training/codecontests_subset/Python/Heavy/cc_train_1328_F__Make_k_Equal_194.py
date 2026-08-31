from math import inf
nk = input().split()
n = int(nk[0])
k = int(nk[1])

a = [int(ai) for ai in input().split()]
a.sort()
possibilities = {}
for ai in a:
    moves = 0
    while ai != 0:
        if ai not in possibilities:
            possibilities[ai] = (1, moves)
        else:
            curr = possibilities[ai]
            if curr[0] != k:
                possibilities[ai] = (curr[0] + 1, curr[1] + moves)
        ai = ai // 2
        moves += 1
minOps = inf
for i in possibilities:
    curr = possibilities[i]
    if curr[0] == k:
        if curr[1] < minOps:
            minOps = curr[1]

print(minOps)
