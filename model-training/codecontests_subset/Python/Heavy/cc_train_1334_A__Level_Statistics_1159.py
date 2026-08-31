for _ in range(int(input())):
    n = int(input())
    p1 = 0
    c1 = 0
    t = 0
    l = []
    for i in range(n):
        p, c = map(int, input().split())
        l.append([p, c])
    for i in l:
        if (i[0] - p1) >= 0 and (i[1] - c1) >= 0:
            if (i[0] - p1) < (i[1] - c1):
                t = 1
                print('NO')
                break
            p1 = i[0]
            c1 = i[1]
        else:
            t = 1
            print('NO')
            break
    if t == 0:
        print('YES')