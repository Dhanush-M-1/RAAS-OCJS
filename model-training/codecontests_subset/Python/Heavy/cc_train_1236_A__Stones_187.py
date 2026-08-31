j=int(input())
ma = []
for i in range(j):
    t=1
    s=0
    a,b,c=input().split()
    a=int(a)
    b=int(b)
    c=int(c)
    while t:
        l=0
        if b<c and c>=2 and b>=1:
            s=s+3
            c=c-2
            b=b-1
            l=l+3
        elif b>c and b>=2 and a>=1:
            s=s+3
            b=b-2
            a=a-1
            l=l+3
        elif a==0:
            if c>=2 and b>=1:
                s=s+3
                c=c-2
                b=b-1
                l=l+3
        elif a!=0:
            if c>=2 and b>=1:
                s=s+3
                c=c-2
                b=b-1
                l=l+3
            elif b>=2 and a>=1:
                s=s+3
                c=c-2
                b=b-1
                l=l+3
        if l==0:
            t=0
    ma.append(s)
for x in ma:
    print(x)
