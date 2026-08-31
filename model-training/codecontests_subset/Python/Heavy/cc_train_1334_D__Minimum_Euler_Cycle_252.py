def oracle(n, start, end):
    nod = 0
    t = n - 1
    ii = 0
    while start - ii > t*2:
        if t == 0:
            nod += 1
            break
        nod += 1
        ii += t*2
        t -= 1
        if t < -10:
            import sys
            sys.exit()
    R = []
    for cur in range(nod, n):
        for v in range(cur+1, n):
            ii += 1
            if start <= ii <= end:
                R.append(cur + 1)
            ii += 1
            if start <= ii <= end:
                R.append(v + 1)
            if ii > end:
                return R
    ii += 1
    if start <= ii <= end:
        R.append(1)
    return R
t = int(input())

for _ in range(t):
    a,b,c = map(int,input().split())
    x = oracle(a, b, c)
    print(*x)
    

