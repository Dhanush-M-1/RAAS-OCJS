for _ in range(int(input())):
    n = int(input())
    x = list(map(int, input().split()))
    a = x[0]
    b = x[1]
    c = x[n-1]
    if a+b <= c:
        print(1, 2, n)
    else:
        print(-1)
  