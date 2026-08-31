n,k = map(int,input().split())
a = []
b = []
ab = []
for _ in range(n):
    t,x,y = map(int,input().split())
    if x == 1 and y == 1:
        ab.append(t)
    elif x == 1 and y == 0:
        a.append(t)
    elif x == 0 and y == 1:
        b.append(t)
if len(ab) + len(a) < k or len(ab) + len(b) < k:
    print(-1)
else:
    a.sort()
    a.append(float('inf'))
    b.sort()
    b.append(float('inf'))
    ab.sort()
    ab.append(float('inf'))
    tm = 0
    ia = 0
    ib = 0
    iab = 0
    books = 0
    while books < k:
        if ab[iab] <= a[ia] + b[ib]:
            tm += ab[iab]
            iab+= 1
        else:
            tm += a[ia] + b[ib]
            ia += 1
            ib += 1
        books += 1
    print(tm)