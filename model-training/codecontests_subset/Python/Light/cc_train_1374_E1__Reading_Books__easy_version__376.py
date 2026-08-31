n , k = map(int,input().split())
a = []
b = []
c =[]
for i in range(n):
    q , w , e =map(int,input().split())
    if(w and e):
        a.append(q)
    elif(w):
        b.append(q)
    elif(e):
        c.append(q)
if(len(a) + len(b)<k or len(a) + len(c)<k):
    print(-1)
else:
    a.sort()
    b.sort()
    c.sort()
    w = 0
    t = 0
    o = 0
    p = 0
    while(w<k):
        if(len(b) > o and len(c) > o and (p == len(a) or c[o] + b[o]< a[p])):

            t =t+c[o] + b[o]
            o = o+1
        else:
            t =t+a[p]
            p = p+1
        w =w+1
    print(t)

