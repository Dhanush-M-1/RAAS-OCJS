from sys import *
t = int(stdin.readline())
while t > 0:
    n = int(stdin.readline())
    fg = n
    c2 = 0
    c3 = 0
    if n == 1:
        ans = 0
    elif (n % 2) != 0 and (n % 3) != 0:
        ans = -1
    else:
        if n % 2 == 0:
            while (n % 2) == 0:
                c2 += 1
                n = n/2
        if n % 3 == 0:
            while (n % 3) == 0:
                c3 += 1
                n = n/3
        if n == 1:
            if c3 == c2:
                ans = c2
            elif c2 > c3:
                ans = -1
            elif c3 > c2:
                ans = c3 - c2 + c3
        else:
            ans = -1
    print(ans)
    t -= 1