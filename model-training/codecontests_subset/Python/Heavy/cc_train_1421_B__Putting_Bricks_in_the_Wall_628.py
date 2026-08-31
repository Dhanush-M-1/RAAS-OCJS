t = int(input())
for f in range(t):
    n = int(input())
    a = ""
    b = ""
    c = ""
    d = ""
    for i in range(1,n+1):
        l = input()
        if i == 1:
            a = l[1]
        elif i == 2:
            b = l[0]
            c = l[n-1]
        elif i == n-1:
            c = l[n-1]
        elif i == n:
            d = l[n-2]
    if (a==b) and (c==d):
        if a==c:
            print(2)
            print(n-1,n)
            print(n,n-1)
        else:
            print(0)
    elif a==b and c!=d:
        if c ==a:
            print(1)
            print(n-1,n)
        else:
            print(1)
            print(n,n-1)
    elif a!=b and c==d:
        if a==c:
            print(1)
            print(1,2)
        else:
            print(1)
            print(2,1)
    else:
        if a==c:
            print(2)
            print(2,1)
            print(n-1,n)
        else:
            print(2)
            print(2,1)
            print(n,n-1)
