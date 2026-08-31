T = int(input())

for test in range(T):
    n = int(input())
    a = [int(x) for x in input().split()]
    if a[0] + a[1] <= a[-1]:
        print("1 2 {}".format(n))
    else: print(-1)