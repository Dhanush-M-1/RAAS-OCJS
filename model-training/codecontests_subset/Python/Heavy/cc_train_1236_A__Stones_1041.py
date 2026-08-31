t=int(input())
for z in range(t):
    a,b,c=input().split()
    a,b,c=int(a),int(b),int(c)
    stones=0
    while True:
        z=0
        f=1
        if c>b>=a or c>a>=b:
            if b>0 and c>1:
                b-=1
                c-=2
                stones+=3
                z=1
            else:
                z=0
        elif a>=b>=c or a>=c>=b or b>=c>=a or b>=a>=c or a==b==c:
            if b>0 and c>1:
                b-=1
                c-=2
                stones+=3
                z=1
            elif a>0 and b>1:
                a-=1
                b-=2
                stones+=3
                z=1
            else:
                z=0
        if z==0:
            if a>=b or b>=a:
                if b<2 or a<1:
                    f=0
                else:
                    f=1
            elif c>=b:
                if c<2 or b<1:
                    f=0
                else:
                    f=1
        if f==0:
            break
    print(stones)
