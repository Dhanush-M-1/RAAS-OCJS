for _ in range(int(input())):
    n, l = int(input()), list(map(int, input().split()))
    if l[0]+l[1]<=l[n-1]: print(1, 2, n)
    else: print(-1)
