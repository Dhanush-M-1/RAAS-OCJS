t = int(input())
sol = []
for i in range(t):
    n = int(input())
    l = list(map(int, input().split()))
    j = l.copy()
    x = min(j)
    j.remove(x)
    y = min(j)
    z = max(j)
    if x + y <= z:
        if x == y:
            x = l.index(x) + 1
            l.remove(y)
            y = l.index(y) + 2
            z = l.index(z) + 2
        else:
            x = l.index(x) + 1
            y = l.index(y) + 1
            z = l.index(z) + 1
        sol.append(str(x) + " " + str(y) + " " + str(z))
    else:
        sol.append("-1")
for i in sol:
    print(i)
