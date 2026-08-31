t=int(input())
for x in range (t):
    n=int(input())
    a=[]
    for i in range (n):
        a.append(input())

    if a[1][0]==a[0][1] and a[n-1][n-2]!=a[n-2][n-1]:
        print(1)
        if a[1][0]==a[n-1][n-2]:

            print(n,n-1)
        else:
            print(n-1,n)


    elif a[1][0]!=a[0][1] and a[n-1][n-2]==a[n-2][n-1]:
        print(1)
        if a[1][0] == a[n - 1][n - 2]:

            print(2, 1)
        else:
            print(1, 2)


    elif a[1][0]!=a[0][1] and a[n-1][n-2]!=a[n-2][n-1]:
        print(2)

        if a[1][0] == a[n - 1][n - 2]:

            print(2, 1)
            print(n-1, n)
        else:
            print(1, 2)
            print(n-1, n)

    elif a[1][0] == a[0][1] and a[n - 1][n - 2] == a[n - 2][n - 1]:
        if a[1][0] == a[n - 1][n - 2]:
            print(2)
            print(2, 1)
            print(1, 2)
        else:
            print(0)


