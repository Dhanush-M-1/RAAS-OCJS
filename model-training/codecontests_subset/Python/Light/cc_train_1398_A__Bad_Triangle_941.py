T = int(input())
for _ in range(T):
    n = int(input())
    ls = list(map(int, input().split()))
    ls.sort()
    a = ls[0]
    b = ls[1]
    c = ls[-1]

    if a + b > c:
        print(-1)
    else:
        print(1, 2, n)
