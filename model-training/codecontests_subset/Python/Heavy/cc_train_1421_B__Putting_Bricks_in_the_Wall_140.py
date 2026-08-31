for _ in range(int(input())):
    n=int(input())
    s=input()
    c1=s[1]
    s=input()
    c2=s[0]
    for i in range(max(n-4,0)):
        s=input()
    if n==3:
        c3=s[n-1]
        s=input()
        c4=s[n-2]
    else:
        s=input()
        c3=s[n-1]
        s=input()
        c4=s[n-2]
    if c1==c2:
        if c3==c4:
            if c3==c1:
                print(2)
                print(n-1,n)
                print(n,n-1)
            else:
                print(0)
        else:
            if c3==c1:
                print(1)
                print(n-1,n)
            else:
                print(1)
                print(n,n-1)
    elif c4==c3:
        if c1==c3:
            print(1)
            print(1,2)
        else:
            print(1)
            print(2,1)
    else:
        if c1==c3:
            print(2)
            print(1,2)
            print(n,n-1)
        else:
            print(2)
            print(1,2)
            print(n-1,n)