# https://codeforces.com/contest/143/problem/A

r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())

if (r1 - c1 + d2) % 2 == 0:
    m = (r1 - c1 + d2) // 2
    l = r1 - m
    n = c1 - l
    o = c2 - m
    gems = {l, m, n, o}

    if len(gems) != 4:
        print(-1)
    else:
        for i in gems:
            if i < 1 or i > 9:
                print(-1)
                break
        else:
            if l + m == r1 and n + o == r2 and l + n == c1 and m + o == c2 and l + o == d1 and n + m == d2:
                print(l, m)
                print(n, o)
            else:
                print(-1)

else:
    print(-1)
