t = int(input())
for _ in range(t):
    n = int(input())
    a = [int(ele) for ele in input().split()]
    if (a[0] + a[1]) <= a[-1]:
        print(1, 2, n, end = " ")
        print("")
    else:
        print(-1)