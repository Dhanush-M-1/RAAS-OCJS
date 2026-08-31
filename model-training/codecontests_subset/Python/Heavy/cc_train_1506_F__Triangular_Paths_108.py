

for case in range(int(input())):
    n = int(input())
    X = list(map(int, input().split()))
    Y = list(map(int, input().split()))

    li = []
    for i in range(n):
        x = X[i]
        y = Y[i]
        li.append((abs(x-y+1), min(x, y)))
    li.sort()
    prvblk = 1
    prvplc = 1
    cost = 0
    for blk, plc in li:
        hor = blk - prvblk
        ver = plc - prvplc
        if hor == 0:
            ## same blk
            if prvblk % 2:
                cost += ver
        else:
            if prvblk % 2:
                cost += hor//2
            else:
                cost += (hor+1)//2

        prvblk = blk
        prvplc = plc
    print(cost)
