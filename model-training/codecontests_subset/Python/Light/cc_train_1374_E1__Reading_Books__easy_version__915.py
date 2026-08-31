n,k = map(int,input().split());d,l,a,b = [],[],[],[]
for _ in range(n):
    p,q,r = map(int,input().split())
    if q == r :
        if q == 0:d.append(p)
        else:l.append(p)
    else:
        if q == 0 and r == 1:b.append(p)
        else:a.append(p)
if (min(len(a),len(b))) + len(l) < k:print(-1)
else:
    a.sort();b.sort();s = [0]*((min(len(a),len(b))))
    for i in range((min(len(a),len(b)))):s[i] = a[i]+b[i]
    r = s+l;r.sort()
    print(sum(r[:k]))