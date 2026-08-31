for _ in range(int(input())):
    n = int(input())
    A = [int(a) for a in input().split()]
    i, j, k = 1, 2, n
    flag = True

    if A[0] + A[1] > A[n - 1]:
        flag = False

    if flag:
        print(i, j, k)
    else:
        print(-1)