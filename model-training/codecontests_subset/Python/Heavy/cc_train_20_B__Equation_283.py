# http://codeforces.com/problemset/problem/20/B

from math import sqrt

a, b, c, = [int(x) for x in input().split(' ')]


def number_solutions(a, b, c):
    d = b**2 - 4*a*c
    if a == 0 and b == 0 and c != 0:
        return 0
    elif a == 0 and b == 0 and c == 0:
        return -1
    elif a == 0 and b != 0:
        return 1
    elif d > 0:
        return 2
    elif d == 0:
        return 1
    else:
        return 0


def quadratic(a, b, c):
    ans = []
    if a == 0:
        ans.append(-c/b)
    else:
        ans.append((-b + sqrt(b**2 - 4*a*c)) / (2*a))
        ans.append((-b - sqrt(b**2 - 4*a*c)) / (2*a))
    return ans


if number_solutions(a, b, c) == -1:
    print(-1)
elif number_solutions(a, b, c) == 2:
    print(2)
    for q in sorted(quadratic(a, b, c)):
        print('{:.5f}'.format(q))
elif number_solutions(a, b, c) == 1:
    print(1)
    print('{:.5f}'.format(quadratic(a, b, c)[0]))
else:
    print(0)
