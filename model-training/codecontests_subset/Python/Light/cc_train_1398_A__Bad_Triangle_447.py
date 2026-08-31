t = int(input())
cnt = 0
while (cnt < t):
    cnt += 1
    n = int(input())
    flag = False
    a = [int(i) for i in input().split()]
    if a[0] + a[1] <= a[n - 1]:
        print(1, 2, n)
    else:
        print(-1)