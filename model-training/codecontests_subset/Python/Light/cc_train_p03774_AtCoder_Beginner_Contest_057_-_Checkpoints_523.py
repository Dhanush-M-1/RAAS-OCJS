n, m = map(int, input().split())

students = [list(map(int, input().split())) for _ in range(n)]
checks = [list(map(int, input().split())) for _ in range(m)]

for s in students:
    dis = [abs(s[0] - c[0]) + abs(s[1] - c[1]) for c in checks]
    print(dis.index(min(dis))+1)
