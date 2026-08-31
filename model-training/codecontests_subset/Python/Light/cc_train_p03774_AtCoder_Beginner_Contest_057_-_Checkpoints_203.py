n, m = map(int, input().split())
p = [list(map(int, input().split())) for _ in range(n)]
c = [list(map(int, input().split())) for _ in range(m)]


def dist(p1, p2):
    return abs(p1[0] - p2[0]) + abs(p1[1] - p2[1])


for i in range(n):
    x = min(c, key=lambda x: dist(p[i], x))
    num = c.index(x) + 1
    print(num)
