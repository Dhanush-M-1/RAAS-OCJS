for _ in range(int(input())):
    n = int(input())
    p, c = map(int, input().split())
    if c > p:
        for i in range(1, n):
            p, c = map(int, input().split())
        print('NO')
        continue
    ok = False
    for i in range(1, n):
        p1, c1 = map(int, input().split())
        if p1 < p or c1 < c or c1 > p1 or c > p:
            ok = True
        if p1 - p < c1 - c:
            ok = True
        p, c = p1, c1
        p, 
    if ok:
        print('NO')
    else:
        print('YES')
        
