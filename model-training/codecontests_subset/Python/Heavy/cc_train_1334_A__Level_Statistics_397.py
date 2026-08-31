t = int(input())
for _ in range(t):
    n = int(input())
    p=[]
    c=[]
    for i in range(n):
        pi, ci = map(int, input().split())
        c.append(ci)
        p.append(pi)
    poss=True
    c0, p0 = c[0], p[0]
    if p0<c0 : poss=False
    for i in range(1,n):
        if p[i]<p[i-1]:
            poss=False
        if c[i]<c[i-1]:
            poss=False
        if p[i]<c[i]:
            poss=False
        if c[i]-c[i-1] > p[i]-p[i-1]:
            poss=False
        if not poss:
            break
    if poss:
        print('YES')
    else:
        print('NO')