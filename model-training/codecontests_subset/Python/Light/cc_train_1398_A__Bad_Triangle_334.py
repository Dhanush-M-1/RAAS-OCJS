t = int(input())
for case in range(t):
    n = int(input())
    a = [int(s) for s in input().split(' ')]
    if a[-1] >= a[0] + a[1]:
        print(1, 2, n)
    else:
        print(-1)
