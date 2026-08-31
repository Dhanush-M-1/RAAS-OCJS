def number_list(): return list(map(int, input().split()))


def arr2d(rows, cols, v=0): return [
    [v for i in range(cols)] for _ in range(rows)]


t = int(input())
for tt in range(t):
    l, r, d = number_list()
    ans = 0
    if d < l or d > r:
        ans = d
    else:
        res = max(r, d) % min(r, d)
        # print("res = " + str(res))
        if res == 0:
            ans = d + r
        else:
            ans = r + ( d - r % d )

    print(ans)
