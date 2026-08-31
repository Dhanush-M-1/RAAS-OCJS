t=int(input())
for i in range(0,t):
    n=int(input())
    x=n
    a=0
    b=0
    while n%3==0 or n%2==0:
        if n%3==0:
            n=n/3
            a=a+1
        else:
            n=n/2
            b=b+1
    if b==0 and a==0 and n==1:
        
        print(0)
    elif n>3:
        print(-1)
        
    elif b>a:
        print(-1)
    else:
        d=0
        while x> 1:
            if x%6==0:
                x=x/6
                d=d+1
            else:
                x=x*2
                d=d+1
        print(d)