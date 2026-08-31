t = int(input())
for _ in range(t):
    n = int(input())
    pc = [tuple(map(int, input().split())) for _ in range(n)]
    flg = True
    for i in range(n):
        if pc[i][0] < pc[i][1]:
            flg = False
    if flg == False:
        print('NO')

    else:
        for i in range(n-1):
            dp = pc[i+1][0] - pc[i][0]
            dc = pc[i+1][1] - pc[i][1]

            if dp < 0:
                flg = False
            if dp == 0:
                if dc != 0:
                    flg = False
            if dp > 0:
                if dp < dc:
                    flg = False
                if dc < 0:
                    flg = False

        if flg:
            print('YES')
        else:
            print('NO')