for _ in range(int(input())):
    n = int(input())
    a = [int(s) for s in input().split()]
    ans = "-1"
    if a[0] + a[1] <= a[-1]:
        ans = str(1) + " " + str(2) + " " + str(n)
    print(ans)