n, m = [int(x) for x in input().split()]
a = [[int(x) for x in input().split()] for y in range(n)]
b = [[int(x) for x in input().split()] for y in range(m)]

for ai in a:
    n = [abs(ai[0] - bi[0]) + abs(ai[1] - bi[1]) for bi in b]
    print(n.index(min(n)) + 1)
