n=int(input())
for i in range(0,n):
    p=input().rstrip().split(' ')
    l=int(p[0])
    r=int(p[1])
    d=int(p[2])
    t=d*1;
    j=1;
    U=0;
    while(t<l):
        if t<l and t<r:
            U=1;
            break;
        if t>l and t>r:
            U=1;
            break;
        j+=1;
        t=d*j;
    if U==1:
        print(t)
    else:
        g=(r//d)+1;
        t=d*g;
        while(t>r):
            if t<l and t<r:
                U=1;
                break;
            if t>l and t>r:
                U=1;
                break;
            g+=1;
            t=d*g;
        print(t)
