n = int(input())

for i in range(0, n):
    l, r, d = map(int, input().split())
    ans = 0
    if l > d:
        ans = d
    else:
        ans = (r // d + 1) * d

    print(ans)
