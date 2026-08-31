t=int(input())
for _ in range(t):
    n=int(input())
    g=[]
    for i in range(n):
        g.append(input())
    a,b,c,d=g[0][1],g[1][0],g[n-1][n-2],g[n-2][n-1]
    if a==b and c==d and a!=c:
        print(0)
    elif a==b and c!=d:
        print(1)
        if c==a:
            print(n,n-1)
        elif d==a:
            print(n-1,n)
    elif c==d and a!=b:
        print(1)
        if a==c:
            print(1,2)
        elif b==c:
            print(2,1)
    elif a==b and c==d and a==c:
        print(2)
        print(1,2)
        print(2,1)
    elif a!=b and c!=d:
        print(2)
        if a==c:
            print(1,2)
            print(n-1,n)
        elif a==d:
            print(1,2)
            print(n,n-1)