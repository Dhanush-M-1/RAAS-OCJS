n, m = [int(i) for i in input().split()]

ab = [list(map(int, input().split())) for i in range(n)]
cd = [list(map(int, input().split())) for i in range(m)]

for i in range(n):
    l = [abs(ab[i][0] - cd[j][0]) + abs(ab[i][1] - cd[j][1]) for j in range(m)]
    print(l.index(min(l)) + 1)