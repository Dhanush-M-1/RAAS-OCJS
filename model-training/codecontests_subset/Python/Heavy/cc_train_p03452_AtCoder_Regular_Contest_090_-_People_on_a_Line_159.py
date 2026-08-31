N, M = map(int, input().split())
xval = [float("INF")]*(N+1)
road = {}
for i in range(1, N+1):
    road[i] = {}
for i in range(M):
    r, l, d = map(int, input().split())
    road[r][l] = d
    road[l][r] = -d

checked = set()
i = 1
while len(checked) < N:
    for j in range(i, N+1):
        if j in checked:
            continue
        else:
            i = j
            checked.add(i)
            break
    xval[i] = 0
    check = set([i])
    while len(check) > 0:
        nextcheck = set()
        for x in check:
            for y in road[x].keys():
                if xval[y] == float("INF"):
                    xval[y] = xval[x] + road[x][y]
                    checked.add(y)
                    nextcheck.add(y)
                else:
                    if xval[y] != xval[x] + road[x][y]:
                        print("No")
                        exit()
                    else:
                        continue
        check = nextcheck
print("Yes")