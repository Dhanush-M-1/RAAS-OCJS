t = int(input())

for _ in range(t):
    n = int(input())
    p = []
    c = []
    good = True
    for i in range(n):
        data = [int(s) for s in input().split()]
        p.append(data[0])
        c.append(data[1])
    for i in range(n):
        if c[i] > p[i]:
            print('NO')
            good = False
            break
        if i > 0 and (p[i] < p[i - 1] or c[i] < c[i - 1] or p[i] - p[i - 1] < c[i] - c[i - 1]):
            print('NO')
            good = False
            break
    if good:
        print('YES')