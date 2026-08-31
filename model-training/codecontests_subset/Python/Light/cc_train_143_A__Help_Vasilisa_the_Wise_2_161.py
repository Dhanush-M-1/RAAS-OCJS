r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())

limit=[1,2,3,4,5,6,7,8,9]

co=False
x1=0
x2=0
x3=0
x4=0
for a in range(1,10):
    b=r1-a
    c=c1-a
    d=d1-a
    if(b in limit and c in limit and d in limit):
        uniq=set()
        uniq.add(a)
        uniq.add(b)
        uniq.add(c)
        uniq.add(d)
        if(b+c==d2 and b+d==c2 and c+d==r2 and len(uniq)==4):
            co=True
            x1=a
            x2=b
            x3=c
            x4=d
            break

if(co):
    print(x1,x2)
    print(x3,x4)
else:
    print("-1")
    
        
