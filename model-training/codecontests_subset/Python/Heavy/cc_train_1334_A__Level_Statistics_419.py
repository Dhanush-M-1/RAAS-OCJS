T = int(input())
t = 0

# n, m = map(int, input().split())
# a = [int(x) for x in input().split()]
while t < T:
    t += 1
    begun = 0
    N = int(input())
    n = 0
    flg = 0
    while n < N:
        n += 1
        p, c = map(int, input().split())

        if not begun:
            begun = 1
            prev_p = p
            prev_c = c
            if p < c:
                flg = 1
            continue

        if p - prev_p < 0:
            flg = 1
        elif c - prev_c < 0:
            flg = 1
        elif p - prev_p < c - prev_c:
            flg = 1
        elif p < c:
            flg = 1

        prev_c = c
        prev_p = p

    if flg:
        print("NO")
    else:
        print("YES")







