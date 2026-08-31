n, m = map(int, input().split())

ST = [[int(x) for x in input().split()] for y in range(n)]
CH = [[int(x) for x in input().split()] for y in range(m)]

for a, b in ST:
    manhat = [abs(a - c) + abs(b - d) for c, d in CH]
    print(manhat.index(min(manhat)) + 1)
