n,k = map(int,input().split())
d,l,a,b = [],[],[],[]
for _ in range(n):
    p,q,r = map(int,input().split())
    if q == r :
        if q == 0:
            d.append(p)
        else:
            l.append(p)
    else:
        if q == 0 and r == 1:
            b.append(p)
        else:
            a.append(p)
m = min(len(a),len(b))
if m + len(l) < k:print(-1)
else:
    a.sort()
    b.sort()
    s = [0]*m
    for i in range(m):
        s[i] = a[i]+b[i]
    r = s+l
    r.sort()
    print(sum(r[:k]))