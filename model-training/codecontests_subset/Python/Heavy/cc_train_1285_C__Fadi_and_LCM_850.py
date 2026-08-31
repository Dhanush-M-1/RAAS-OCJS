from sys import stdin
import math


def mp(l):
    # Multiply elements one by one
    result = 1
    for x in l:
        result = result * x
    return result


def prime_factors(n):
    l = []
    while n % 2 == 0:
        l.append(2)
        n = n // 2
    for i in range(3, int(math.sqrt(n)) + 1, 2):
        while n % i == 0:
            l.append(i)
            n = n // i

    if n > 2:
        l.append(n)
    return l


n = int(stdin.readline().rstrip())
if n == 1:
    print(1, 1)
else:

    l = prime_factors(n)
    if l[0]==l[-1]:
        print(1, n)
    else:
        d = []
        s = list(set(l))
        for i in range(len(s)):
            d.append(s[i]**l.count(s[i]))
        d.sort()

        r = [set()]
        for i in range(len(d)):
            for j in range(len(r)):
                z = r[j].copy()
                z.add(d[i])
                r.append(z)
        a = 999999999999999999999999
        b = 0
        diff = a-b
        for i in range(1, len(r)-1):
            n1 = mp(list(r[i]))
            n2 = n//n1
            if abs(n1 - n2) < diff:
                a = max(n1,n2)
                b = min(n1,n2)
                diff = abs(n1-n2)
        print(b, a)