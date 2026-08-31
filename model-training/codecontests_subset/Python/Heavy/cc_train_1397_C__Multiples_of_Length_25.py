
def tc():
    n = int(input())
    a = list(map(int, input().split()))

    if n == 1:
        print(1, 1)
        print(-a[0])
        for _ in range(2):
            print(1, 1)
            print(0)
        return
    # steps:
    # keep adding on 1...N-1 until x % n == n - 1
    # make a[N-1] 0
    # keep adding on 1...N

    first = []
    for i, x in enumerate(a[:-1]):
        rem = x % n
        if rem <= n // 2:  # faster to add
            delta = rem * (n - 1)
        else:
            delta = -(n - rem) * (n - 1)
        a[i] += delta
        first.append(delta)

    print(1, n - 1)
    print(' '.join(map(str, first)))

    print(n, n)
    print(-a[-1])

    third = []
    for x in a[:-1]:
        third.append(-x)
    third.append(0)

    print(1, n)
    print(' '.join(map(str, third)))


#################
# T = int(input())
# for _ in range(T):
tc()
