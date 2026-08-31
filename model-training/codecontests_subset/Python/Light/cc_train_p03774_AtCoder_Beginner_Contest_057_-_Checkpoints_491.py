n, m = map(int, input().split())
AB = [list(map(int, input().split())) for i in range(n)]
CD = [list(map(int, input().split())) for i in range(m)]

for a, b in AB:
    dist = [[abs(a - c) + abs(b - d)] for c, d in CD]
    print(dist.index(min(dist)) + 1)