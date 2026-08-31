q = int(input())
l = []
r = []
d = []
for i in range(q):
    x,y,z = [int(a) for a in input().split() ]
    l.append(x)
    r.append(y)
    d.append(z)
def FindMinPos(l,r,d,q):
    resTab = []
    for i in range(q):
        if d[i] >= l[i] and d[i] <= r[i]:
            remain = r[i] % d[i]
            if remain == 0:
                res = r[i] + d[i] 
            else:
                res = r[i] +( d[i] -remain )
        else:
            res = d[i]
        resTab.append(res)
    for x in resTab:
        print(x)
FindMinPos(l,r,d,q)

