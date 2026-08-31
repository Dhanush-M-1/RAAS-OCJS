N, M = list(map(int, input().split()))
ab = [list(map(int, input().split())) for i in range(N)]
cd = [list(map(int, input().split())) for i in range(M)]

for a, b in ab:
    tmp = []
    for c, d in cd:
        tmp.append(abs(a-c) + abs(b-d))
    n = min(tmp)
    print(tmp.index(n)+1)