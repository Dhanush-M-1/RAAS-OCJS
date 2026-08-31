import math
num = int(input())

for _ in range(num):
    _n = int(input())
    a = list(map(int, input().split()))
    diff = 0
    l = set()

    for i in range(len(a) - 1):
        x = a[i]
        y = a[i + 1]
        if x != -1 and y != -1:
            diff = max([diff, abs(x - y)])
        elif x == -1 and y == -1:
            pass
        else:
            l.add(max([x, y]))
    
    if len(l) != 0:
        ansdif = math.ceil((max(l) - min(l)) / 2)
        ans = min(l) + ansdif
        diff = max([diff, ansdif])
    else:
        ans = 0
    print(diff, ans)