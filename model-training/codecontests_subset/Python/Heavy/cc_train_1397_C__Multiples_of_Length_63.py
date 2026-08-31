n = int(input())
arr = list(map(int, input().split()))

if n>1:
    l1 = []
    for i in range(n-1):
        l1.append((arr[i]%n)*(n-1))
    print(1, n-1)
    print(*l1)
    print(n, n)
    print(-(arr[-1]%n))
    print(1, n)
    l2 = []
    for i in range(n):
        if i<(n-1):
            val = arr[i]+l1[i]
        else:
            val = arr[i]-(arr[-1]%n)

        l2.append(val*-1)
    print(*l2)
else:
    print(1, 1)
    print(-arr[0])
    print(1, 1)
    print(0)
    print(1, 1)
    print(0)
