import math

t = input()
t = int(t)
while t > 0:
    n = input()
    n = int(n)

    s = input()
    s = [int(x) for x in s.split()]

    if s[0] + s[1] > s[-1]:
        print(-1)
    else:
        print(1, 2, n)

    t -= 1
