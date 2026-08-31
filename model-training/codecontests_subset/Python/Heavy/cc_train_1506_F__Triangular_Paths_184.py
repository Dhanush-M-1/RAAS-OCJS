for _ in range(int(input())):
    n = int(input())
    row = map(int,input().split())
    col = map(int,input().split())
    pos = [(1,1)]
    for r,c in zip(row,col):
        pos.append((r,c))
    pos.sort()
    cost = 0

    for i in range(n):
        r1,c1 = pos[i]
        r2,c2 = pos[i+1]
        if r1-c1 == r2-c2 :
            if (r1 -c1)% 2 == 0:
                cost += r2 - r1
        else:
            d = abs((r1-c1) - (r2-c2))
            cost += d // 2
            if d % 2 == 1 and (r1-c1) % 2 == 1:
                cost += 1
    print(cost)
