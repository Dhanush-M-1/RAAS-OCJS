for _ in range(int(input())):
    n = int(input())
    a = [input() for j in range(n)]
    if (a[0][1] == a[1][0] == '1' and a[n-2][n-1] == a[n-1][n-2] == '0') or (a[0][1] == a[1][0] == '0' and a[n-2][n-1] == a[n-1][n-2] == '1'):
        print(0)
    else:
        n1,n2,n3,n4 = int(a[0][1]), int(a[1][0]), int(a[n-1][n-2]), int(a[n-2][n-1])
        if n1 + n2 == n3+n4 == 0 or n1+n2==n3+n4==2:
            print(2)
            print(1, 2)
            print(2, 1)
        elif n1 + n2 == 1 and n3+n4 == 1:
            print(2)
            print(1, 2)
            if n1 == 1:
                if n3 == 0:
                    print(n, n-1)
                else:
                    print(n-1, n)
            else:
                if n3 == 1:
                    print(n, n-1)
                else:
                    print(n-1, n)
        elif n1+n2 == 0 and n3+n4 == 1:
            print(1)
            if n3 == 0:
                print(n, n-1)
            else:
                print(n-1, n)
        elif n1+n2 == 1 and n3+n4==0:
            print(1)
            if n1 == 0:
                print(1,2)
            else:
                print(2,1)
        elif n1 + n2 == 1 and n3+n4==2:
            print(1)
            if n1 == 1:
                print(1,2)
            else:
                print(2,1)
        else:
            print(1)
            if n3 == 1:
                print(n,n-1)
            else:
                print(n-1,n)