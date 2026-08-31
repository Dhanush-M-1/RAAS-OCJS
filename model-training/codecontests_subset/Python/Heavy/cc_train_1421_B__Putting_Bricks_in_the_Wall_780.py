for _ in range(int(input())):
    n = int(input())
    A = [input() for i in range(n)]
    if A[0][1] == A[1][0]:
        if A[n-2][n-1] == A[n-1][n-2]:
            if A[n-2][n-1] == A[0][1]:
                print(2)
                print(1, 2)
                print(2, 1)
            else:print(0)
        else:
            print(1)
            if A[0][1] == A[n-2][n-1]:print(n-1, n)
            else:print(n, n-1)
    else:
        if A[n-2][n-1] == A[n-1][n-2]:
            print(1)
            if A[n-2][n-1] == A[0][1]:print(1, 2)
            else:print(2, 1)
        else:
            print(2)
            if A[0][1] == A[n-1][n-2]:
                print(1, 2)
                print(n-1, n)
            else:
                print(2, 1)
                print(n-1, n)