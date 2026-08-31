n,m = map(int, input().split())
ab = [list(map(int, input().split())) for _ in range(n)]
cd = [list(map(int, input().split())) for _ in range(m)]

for i in ab:
    ans = []
    for j in cd:
        ans.append(abs(i[0] - j[0]) + abs(i[1] - j[1]))
    print(ans.index(min(ans))+1)