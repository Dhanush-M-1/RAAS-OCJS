n, m = map(int, input().split())
ab = [list(map(int, input().split())) for _ in range(n)]
cd = [list(map(int, input().split())) for _ in range(m)]

for i in range(n):
    dis = []
    for j in range(m):
        dis.append(abs(ab[i][0]-cd[j][0]) + abs(ab[i][1]-cd[j][1]))
    print(dis.index(min(dis))+1)