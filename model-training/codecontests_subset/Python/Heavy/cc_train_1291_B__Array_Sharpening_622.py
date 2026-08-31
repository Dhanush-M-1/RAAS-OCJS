t = int(input())
for fashjufjh in range(t):
    n = int(input())
    a = list(map(int,input().split()))
    if n % 2:
        f = True
        for i in range(n):
            if a[i] < min(i, n - i - 1):
                f = False
                break
        if f:
            print("Yes")
        else:
            print("No")
    else:
        f1 = True
        for i in range(n // 2 - 1):
            if a[i] < i:
                f1 = False
                break
        for i in range(n // 2 - 1, n):
            if a[i] < n - i - 1:
                f1 = False
                break
        f2 = True
        for i in range(n // 2 + 1):
            if a[i] < i:
                f2 = False
                break
        for i in range(n // 2 + 1, n):
            if a[i] < n - i - 1:
                f2 = False
                break
        if f1 or f2:
            print("Yes")
        else:
            print("No")
