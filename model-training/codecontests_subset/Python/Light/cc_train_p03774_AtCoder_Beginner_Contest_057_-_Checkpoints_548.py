n,m = map(int, input().split())
nlst = [[int(i) for i in input().split()] for _ in range(n)]
mlst = [[int(i) for i in input().split()] for _ in range(m)]

for i in nlst:
    tmp = [abs(i[0] - j[0]) + abs(i[1] - j[1]) for j in mlst]
    print(tmp.index(min(tmp)) + 1)