n, m = map(int, input().split())
ab = [list(map(int, input().split())) for i in range(n)]
cd = [list(map(int, input().split())) for i in range(m)]

for i in ab:
    ans = []
    for j in cd:
        kyori = abs(i[0]-j[0]) + abs(i[1]-j[1])
        ans.append(kyori)
    print(ans.index(min(ans))+1)