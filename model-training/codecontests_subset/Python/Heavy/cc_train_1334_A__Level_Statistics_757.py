t = int(input(''))
for _ in range(t):
    n = int(input(''))
    res = True
    p = []
    c = []
    for i in range(n):
        pp,cc = list(map(int,input('').split(' ')))
        p.append(pp)
        c.append(cc)
    if(p[0] < c[0]):
        print('NO')
        continue
    for i in range(1,n,1):
        if(p[i-1] > p[i] or c[i-1] > c[i] or c[i] > p[i]):
            res = False
            break
        if(p[i]-p[i-1] < c[i] - c[i-1]):
            res = False
            break
    
    if(res):
        print('YES')
        continue
    print('NO')