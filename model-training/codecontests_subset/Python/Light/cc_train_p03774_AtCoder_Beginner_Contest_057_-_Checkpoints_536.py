n, m = map(int, input().split())
AB = [[int(i) for i in input().split()] for i in range(n)]
CD = [[int(i) for i in input().split()] for i in range(m)]

for a, b in AB:
    dist = [abs(a - c) + abs(b - d) for c, d in CD]
    print(dist.index(min(dist)) + 1)