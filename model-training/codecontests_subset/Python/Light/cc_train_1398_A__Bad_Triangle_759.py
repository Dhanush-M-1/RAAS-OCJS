for i in range(int(input())):
    n = int(input())
    L = list(map(int, input().split()))
    if L[n - 1] >= L[0] + L[1]:
        print(1, 2, n)
    else:
        print(-1)
