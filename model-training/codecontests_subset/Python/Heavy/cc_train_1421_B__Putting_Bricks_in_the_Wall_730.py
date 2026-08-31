t=int(input())
for _ in range(t):
    n=int(input())
    for w in range(n):
        s=input()
        if w==0:
            a=s[1]
        if w==1:
            b=s[0]
        if w==n-2:
            c=s[n-1]
        if w==n-1:
            d=s[n-2]
    e=0
    if a==b:
        if c==a and d==a:
            print(2)
            print(n-1, n)
            print(n, n-1)
        elif c==a and d!=a:
            print(1)
            print(n-1, n)
        elif c!=a and d==a:
            print(1)
            print(n, n-1)
        else:
            print(0)
    else:
        if c==d:
            if a==c:
                print(1)
                print(1, 2)
            else:
                print(1)
                print(2, 1)
        else:
            if a==d:
                print(2)
                print(n, n-1)
                print(2, 1)
            else:
                print(2)
                print(n, n-1)
                print(1, 2)