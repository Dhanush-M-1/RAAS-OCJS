k = int(input()
        )
for i in range(k):
    n = int(input())
    A = list(map(int, input().split()))
    f = 0
    if n % 2:
        for i in range(n // 2 + 1):
            if A[i] < i:
                f = 1
        for i in range(n // 2 + 1, n):
            if A[i] < n - i - 1:
                f = 1
    else:
        f1 = 0
        f2 = 0
        for i in range(n // 2):
            if A[i] < i:
                f1 = 1
        for i in range(n // 2, n):
            if A[i] < n - i - 1:
                f1 = 1
        for i in range(n // 2):
            if A[i] < i:
                f2 = 1
        for i in range(n // 2, n):
            if A[i] < n - i - 1:
                f2 = 1
        if (A[n // 2 - 1] == A[n // 2] and A[n // 2] <= n // 2 - 1):
            f = 1
        f += f1 * f2
    if f:
        print("No")
    else:
        print("Yes")