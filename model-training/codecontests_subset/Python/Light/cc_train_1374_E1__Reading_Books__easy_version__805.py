n,k = map(int,input().split())
a = []
b =[]
c = []
c1 = []
for i in range(n):
    q,w,e = map(int,input().split())
    if w== 1 and e == 1:
        c.append(q)
    if w == 1 and e == 0:
        a.append(q)
    if w == 0 and e == 1:
        b.append(q)
a = sorted(a)
b = sorted(b)
for i in range(min(len(a),len(b))):
    c.append(a[i]+b[i])
c = sorted(c)
if len(c)<k:
    print(-1)
    exit(0)
s = 0
for i in range(k):
    s+=c[i]
print(s)