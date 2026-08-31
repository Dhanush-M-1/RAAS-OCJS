for i in range(int(input())):
    n = int(input())
    ans = True
    ch = 0
    f = 1
    s = list(map(int, input().split()))
    p = s * 1
    s[0] = 0
    for i in range(1, len(s)):
        if ch == 0:
            if s[i] >= f:
                s[i] = f
                f += 1
            else:
                s[i - 1] = p[i - 1]
                ch = 1
                f = s[i - 1] - 1
        if ch == 1:
            if f < 0:
                ans = False
                break
            else:
                if s[i] >= f:
                    s[i] = f
                    f -= 1
                else:
                    f = s[i] - 1
    f = p[0] - 1
    help = 0
    for i in range(1, len(p)):
        if f < 0:
            help = -1
            break
        else:
            if p[i] >= f:
                p[i] = f
                f -= 1
            else:
                f = p[i] - 1
    if not ans:
        if help == 0:
            ans = True
    if ans:
        print('Yes')
    else:
        print('No')