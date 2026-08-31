n = int(input())
A = list(map(int, input().split()))

if n == 1:
    print(1, 1)
    print(0)
    print(1, 1)
    print(0)
    print(1, 1)
    print(-A[0])
    exit()

if A[-1] != n:
    print(n, n)
    print(n-A[-1])
    A[-1] = n
    print(1, n-1)
    res = []
    for i in range(n-1):
        res.append((n-1)*A[i])
    print(*res)
    print(1, n)
    res = []
    for i in range(n-1):
        res.append(-n*A[i])
    res.append(-A[-1])
    print(*res)

else:
    print(1, 1)
    print(0)
    print(1, n-1)
    res = []
    for i in range(n-1):
        res.append((n-1)*A[i])
    print(*res)
    print(1, n)
    res = []
    for i in range(n-1):
        res.append(-n*A[i])
    res.append(-A[-1])
    print(*res)
