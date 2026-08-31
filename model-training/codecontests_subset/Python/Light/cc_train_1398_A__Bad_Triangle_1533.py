def solve():
    n = int(input())
    a = input().split(" ")
    a = [int(i) for i in a]
    if a[0] + a[1] <= a[-1]:
        print(1, 2, n)
    else:
        print(-1)


t = int(input())
for i in range(t):
    solve()
