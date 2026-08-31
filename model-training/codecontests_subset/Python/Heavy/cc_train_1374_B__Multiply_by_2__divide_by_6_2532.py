t=int(input())
for _ in range(t):
    n=int(input())
    z=n
    if n==1:
        print(0)
    else:
        x=0
        y=0
        if n%2==0 or n%3==0:
            while n%2==0:
                n=n//2
                x=x+1
            while n%3==0:
                n=n//3
                y=y+1
            if y>0 and x<y and (2**x)*(3**y)==z:
                k=y-x
                n=z*(2**k)
                c=k
                while n%6==0:
                    n=n//6
                    c=c+1
                print(c)
            elif y>0 and x==y and (2**x)*(3**y)==z:
                k=0
                while z%6==0:
                    z=z//6
                    k=k+1
                print(k)
            else:
                print(-1)
        else:
            print(-1)