t = int(input())

for i in range(t):

    pc = []
    n = int(input())
    for j in range(n):
        p, c = map(int, input().split())
        pc.append((p, c))



    good = True

    if n > 1:
        for k in range(n - 1):
            p, c = pc[k]
            pn, cn = pc[k+1]

            if p > pn or c > cn or cn > pn or (pn == 0 and cn > 0) or (p == 0 and c > 0) or ( p == pn and c != cn) or p < c or (pn - p < cn - c):
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
