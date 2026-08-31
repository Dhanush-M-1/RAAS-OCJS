from math import gcd
from functools import reduce

n = int(input())
numbers = [int(k) for k in input().split(" ")]


def find_gcd(list):
    x = reduce(gcd, list)
    return x


if n == 2:
    print("1 "+str(abs(numbers[1]-numbers[0])))
else:
    gc = find_gcd(numbers)
    maxi = max(numbers)
    t = 0
    px = []
    for k in numbers:
        r = int((maxi - k)/gc)
        if r > 0:
            px.append(r)
        t += r
    ng = find_gcd(px)
    if ng > 1:
        t = int(t/ng)
        gc = gc*ng

    print(t, gc)