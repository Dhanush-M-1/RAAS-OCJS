for _ in range(int(input())):
    n=int(input())
    l=[input() for i in range(n)]
    if l[0][1]==l[1][0] and l[n-1][n-2]==l[n-2][n-1]:
        if l[0][1]!=l[n-1][n-2]:
            print(0)
        else:
            print(2)
            print(0+1,2)
            print(2,1)
    elif l[0][1]!=l[1][0] and l[n-1][n-2]==l[n-2][n-1]:
        if l[0][1]==l[n-1][n-2]:
            print(1)
            print(1,2)
        else:
            print(1)
            print(2,1)
    elif l[0][1]==l[1][0] and l[n-1][n-2]!=l[n-2][n-1]:
        if l[0][1]==l[n-1][n-2]:
            print(1)
            print(n,n-1)
        else:
            print(1)
            print(n-1,n)
    else:
        if l[0][1]==l[n-1][n-2]:
            print(2)
            print(2,1)
            print(n,n-1)
        elif l[0][1]==l[n-2][n-1]:
            print(2)
            print(2,1)
            print(n-1,n)
        elif l[1][0]==l[n-1][n-2]:
            print(2)
            print(1,2)
            print(n,n-1)
        else:
            print(2)
            print(1,2)
            print(n-1,n)