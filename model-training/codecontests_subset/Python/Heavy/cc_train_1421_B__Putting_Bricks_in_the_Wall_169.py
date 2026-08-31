t = int(input())
for _ in range(t):
    n = int(input())
    A = []
    for _ in range(n):
        A.append(input())
    if A[0][1] == A[1][0] and A[-1][-2] == A[-2][-1]: # 4 cases
        if A[0][1] != A[-1][-2]:
            print(0)
        else:
            print(2)
            print(1, 2)
            print(2, 1)
    elif A[0][1] != A[1][0] and A[-1][-2] != A[-2][-1]: # 4 cases
        print(2)
        if A[0][1] == A[-1][-2]:
            print(2, 1)
            print(n, n - 1)
        else:
            print(1, 2)
            print(n, n - 1)
    elif A[0][1] != A[1][0]: # 4 cases
        print(1)
        if A[-1][-2] == '0':
            if A[0][1] == '1':
                print(2, 1)
            else:
                print(1, 2)
        else:
            if A[0][1] == '0':
                print(2, 1)
            else:
                print(1, 2)
    else : # A[-1][-2] != A[-2][-1]: # 4 cases
        print(1)
        if A[1][0] == '0':
            if A[-1][-2] == '1':
                print(n - 1, n)
            else:
                print(n, n - 1)
        else:
            if A[-1][-2] == '0':
                print(n - 1, n)
            else:
                print(n, n - 1)

