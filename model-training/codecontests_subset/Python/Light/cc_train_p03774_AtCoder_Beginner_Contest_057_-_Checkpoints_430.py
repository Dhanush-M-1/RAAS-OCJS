N, M = map(int, input().split())
Ss = [tuple(map(int, input().split())) for i in range(N)]
CPs = [tuple(map(int, input().split())) for i in range(M)]

for a, b in Ss:
    dist = [abs(a - c) + abs(b - d) for c, d in CPs]
    print(dist.index(min(dist)) + 1)
