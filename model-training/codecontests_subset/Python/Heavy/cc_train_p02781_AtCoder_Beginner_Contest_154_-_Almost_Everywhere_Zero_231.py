import sys
readline = sys.stdin.readline

L = list(map(int, readline().strip()))
LN = len(L)
K = int(readline())

dpp = [0]*(K+1)
dpp[1] = 1
dpn = [0]*(K+1)
dpn[0] = 1
dpn[1] = L[0]-1
for l in L[1:]:
    dpp2 = [0]*(K+1)
    dpn2 = dpn[:]
    for i in range(1, K+1):
        dpn2[i] += 9*dpn[i-1]
        if l:
            dpn2[i] += (l-1)*dpp[i-1] + dpp[i]
    if not l:
        dpp2 = dpp[:]
    else:
        for i in range(1, K+1):
            dpp2[i] = dpp[i-1]
    dpp = dpp2[:]
    dpn = dpn2[:]

print(dpp[K] + dpn[K])