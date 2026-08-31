t=int(input())
while t>0:
    t-=1
    n=int(input())
    a=[]
    for i in range(n):
        b=input()
        a.append(b)
    c=int(a[0][1])
    d=int(a[1][0])
    e=int(a[-1][-2])
    f=int(a[-2][-1])
    if c==d and e==f and c!=e:
        print(0)
    elif c==d and e==f and c==e:
        print(2)
        print(1,2)
        print(2,1)
    elif c!=d and e!=f:
        print(2)
        if c==0:
            print(1,2)
        if d==0:
            print(2,1)
        if e==1:
            print(n,n-1)
        if f==1:
            print(n-1,n)
    elif c==d:
        print(1)
        if c==e:
            print(n,n-1)
        else:
            print(n-1,n)
    elif e==f:
        print(1)
        if c==e:
            print(1,2)
        else:
            print(2,1)
            
            