t=int(input())
for i in range(t):
    n=int(input())
    l=[]
    for j in range(n):
        s=input()
        l.append(s)
    a=l[0][1]
    b=l[1][0]
    c=l[n-2][n-1]
    d=l[n-1][n-2]
    if a==b:
        if c==a and d==a:
            print('2')
            print(n,n-1)
            print(n-1,n)
        elif c==a:
            print('1')
            print(n-1,n)
        elif d==a:
            print('1')
            print(n,n-1)
        else:
            print('0')
    elif c==d:
        if c==a and c==b:
            print('2')
            print('1 2')
            print('2 1')
        elif c==a:
            print('1')
            print('1 2')
        elif c==b:
            print('1')
            print('2 1')
        else:
            print('0')
    else:
        print('2')
        print('1 2')
        if a==c:
            print(n,n-1)
        else:
            print(n-1,n)