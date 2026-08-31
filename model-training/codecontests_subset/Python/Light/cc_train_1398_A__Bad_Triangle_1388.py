T = int(input())
res = list()
for _ in range(T):
    n = int(input())
    x = list(map(int, input().split()))

    if len(x) <= 2:
        res.append([-1])
        continue

    a, b = x[0], x[1]

    ok = False
    for i in range(2, len(x)):
        if a + b <= x[i]:
            res.append([1, 2, i + 1])
            ok = False
            break
        else:
            ok = True

    if ok:
        res.append([-1])

for i in res:
    if len(i) == 3:
        print(i[0], i[1], i[2])
    else:
        print(i[0])