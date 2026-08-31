t = int(input())
d = dict()
maxim = dif = 0
ans = True

for o in range(t):
    n = int(input())
    a, b = map(int, input().split())
    if b > a:
        ans = False
    for z in range(n - 1):
        c, d = map(int, input().split())
        if d > c:
            ans = False
        if ans == False:
            continue
        if c - a < d - b or d - b < 0 or c - a < 0:
            ans = False
            continue
        a, b = c, d
        c = d = 0
    if ans == True:
        print('YES')
    else:
        print('NO')
    ans = True