
while True:

    N = int(input())

    if N == 0:
        break

    a = list(input().split())

    l = 0
    r = 0

    las = 0
    ans = 0

    for i in a:

        if i == "lu":
            l += 1
        elif i == "ld":
            l -= 1
        elif i == "ru":
            r += 1
        else:
            r -= 1

        if l == r and l != las:
            ans += 1
            las = l

    print (ans)

