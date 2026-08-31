n = int(input())
for i in range(n):
    l, r, d = map(int, input().split())
    flag = False
    if not l <= d <= r:
        print(d)
    else:
        print((r // d + 1) * d)
