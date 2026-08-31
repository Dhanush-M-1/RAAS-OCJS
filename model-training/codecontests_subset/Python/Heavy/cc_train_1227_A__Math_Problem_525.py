t = int(input())
for q in range(0, t):
    n = int(input())
    a = []
    for i in range(0, n):
        c, d = map(int, input().split())
        a.append([c, 0])
        a.append([d, 1])
    a.sort()
    bal = 0
    r = 0
    l = 0
    for i in range(0, 2 * n):
        if a[i][1] == 0:
            bal += 1
        else:
            if bal != n:
                l = a[i][0]
            break
    a.reverse()
    bal = 0
    for j in range(0, 2 * n):
        if a[j][1] == 1:
            bal += 1
        else:
            if bal != n:
                r = a[j][0]
            break
    print(r - l)
