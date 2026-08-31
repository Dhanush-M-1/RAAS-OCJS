t = int(input())

for i in range(t):

    pc = []
    n = int(input())
    for j in range(n):
        p, c = map(int, input().split())
        pc.append((p, c))



    good = True

    if n > 1:
        a, b = pc[0]
        if a < b:
            good = False
        else:
            for k in range(n - 1):
                p, c = pc[k]
                pn, cn = pc[k+1]

                if (pn - p < cn - c) or (pn - p < 0 or cn - c < 0):
                    good = False
    else:
        for k in range(n):
            p, c = pc[k]

            if (p == 0 and c > 0) or (p < c):
                good = False


    if good:
        print('YES')
    else:
        print('NO')
