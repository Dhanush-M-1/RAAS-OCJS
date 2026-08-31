r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())
def fn1(l):
    if len(set(l))<4:return -1
    elif max(set(l))>9:return -1
    elif min(set(l))<1:return -1
    else:return l
def fn(r1,r2,c1,c2,d1,d2):
    for i in range(1,10):
        a=i
        b=r1-a
        c=c1-a
        d=c2-b
        l=[a,b,c,d]
        if a+d==d1 and b+c==d2 and c+d==r2:return fn1(l)
    return -1
t1=fn(r1,r2,c1,c2,d1,d2)
if fn(r1,r2,c1,c2,d1,d2)==-1:print(-1)
else:
    print(t1[0],t1[1])
    print(t1[2],t1[3])
