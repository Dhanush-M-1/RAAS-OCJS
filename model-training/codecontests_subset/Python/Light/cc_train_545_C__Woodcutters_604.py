n = int(input())
p1, h1 = [int(i) for i in input().split()]
if (n == 1):
    print(1)
else:
    c1, h2 = [int(i) for i in input().split()]
    ans = 1
    for i in range(1, n - 1):
        n1, h3 = [int(i) for i in input().split()]
        if (c1 - p1) > h2:
            ans += 1
        elif n1 - c1 > h2:
            ans += 1
            c1 = c1 + h2
        p1 = c1
        c1, h2 = n1, h3
    print(ans + 1)