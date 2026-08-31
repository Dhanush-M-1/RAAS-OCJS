n,k=map(int, input().split())
la=[]
lb=[]
lt=[]
a1=0
b1=0
co=0
for i in range(n):
    t,a,b=map(int, input().split())
    if a==1:
        if b!=1:
            la.append(t)
        a1=a1+1
    if b==1:
        if a!=1:
            lb.append(t)
        b1=b1+1
    if a==1 and b==1:
        lt.append(t)
if a1<k or b1<k:
    print(-1)
else:
    la.sort()
    lb.sort()
    v=len(lt)
    lt.sort()
    lt1=[]
    if v>k:
        for i in range(k):
            lt1.append(lt[i])
    else:
        lt1=lt
    m=k-len(lt1)
    co=sum(lt1)
    co1=0
    x=len(la)
    y=len(lb)
    for i in range(k):
        if k>x or k>y:
            co1=-1
            break
        co1=co1+(la[i]+lb[i])
    for i in range(m):
        if i>x or i>y:
            co=-1
            break
        co=co+(la[i]+lb[i])
    lt1.reverse()
    j=0
    h=m
    z=len(lt1)
    while True:
        if h<x and h<y and j<z:
            if lt1[j]>(la[h]+lb[h]):
                co=co-lt1[j]
                co=co+(la[h]+lb[h])
                j=j+1
                h=h+1
            else:
                break
        else:
            break
    if co==-1:
        print(co1)
    elif co1!=-1:
        print(min(co,co1))
    else:
        print(co)