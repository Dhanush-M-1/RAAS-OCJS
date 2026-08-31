import math
t = int(input()) 
for T in range(t):
    n = int(input())
    a =[int(x) for x in input().split()]
    diff = 0
    l = set()
 
    for i in range(n - 1):
        x = a[i]
        y = a[i + 1]
        if x != -1 and y != -1:
            diff = max([diff, abs(x - y)])
        elif x == -1 and y == -1:
            continue
        else:
            l.add(max([x, y]))
    
    if len(l) != 0:
        ansdif = math.ceil((max(l) - min(l)) / 2)
        ans = min(l) + ansdif
        diff = max([diff, ansdif])
    else:
        ans = 0
    
    print(diff, ans)
