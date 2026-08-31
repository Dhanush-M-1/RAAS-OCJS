t = int(input())
for case in range(t):
    l, r, d = [int(x) for x in input().split(' ')]
    if d < l:
        ans = d
    else:
        ans = d * (r // d + 1)
    print(ans)