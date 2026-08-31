def inp():
    return map(int, input().split())

c = 0
def divide(x):
    if x == 1:
        return

    if x % 2 == 0:
        divide(x // 2)
    elif x % 3 == 0:
        divide(x // 3)
    elif x % 5 == 0:
        divide(x // 5)
    else:
        exit(print(-1))
    global c
    c +=1

# def factorize(n):  # o(sqr(n))
#     c, ans = 1, 0
#     while (c ** 2 <= n):
#         if n % c == 0:
#             ans += 1
#             if divide(c) or divide(n // c):
#                 exit(print(-1))
#         c += 1
#     return ans


from math import *

a, b = inp()
g = gcd(a, b)

if a == b:
    print(0)
else:
    divide(a // g)
    divide(b // g)
    print(c)
