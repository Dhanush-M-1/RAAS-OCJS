import math


def fun(n):
    l = [1]
    x = 1
    while n % 2 == 0:
        x *= 2
        n = n / 2
    if x > 1:
        l.append(x)
    sq = (math.sqrt(n))
    i = 3
    while i < sq + 1+1:
        x = 1
        if n % i == 0:
            j = n // i
            while n % i == 0:
                x *= i
                n = n / i
            if x > 1:
                l.append(x)
        i += 2
    if n > 1:
        l.append(n)
    return l


n = int(input())
ff = fun(n)
fa = 1e20
fb = 1e20


for x in range(1 << len(ff)):
    a = 1
    b = 1
    for i in range(len(ff)):
        if x & (1 << i) != 0:
            a *= ff[i]
        else:
            b *= ff[i]
    if max(fa, fb) > max(a, b):
        fa, fb = a, b
# print(ff)
print(int(fa), int(fb))
