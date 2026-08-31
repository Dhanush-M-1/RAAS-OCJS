n, m = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]
c = [list(map(int, input().split())) for _ in range(m)]

for i in range(n):
    bag = []
    for k in range(m):
        bag.append(abs(a[i][0] - c[k][0]) + abs(a[i][1] - c[k][1]))
    ind = bag.index(min(bag))
    print(ind + 1)
