for k in range(int(input())):
    l, r, d = map(int, input().split())
    if d < l:
        print(d)
    else:
        i = r // d
        ans = d
        while r >= ans:
            ans = d * i
            i += 1
        print(ans)
