n, m = map(int, input().split())
ab = [list(map(int, input().split())) for _ in range(n)]
cd = [list(map(int, input().split())) for _ in range(m)]

for per in ab:
    diff = []
    for check in cd:
        diff.append(abs(per[0]-check[0]) + abs(per[1]-check[1]))
    print(diff.index(min(diff))+1)