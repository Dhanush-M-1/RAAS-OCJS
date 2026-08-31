from collections import defaultdict
from math import ceil


def prime_factors(n):
    ret = defaultdict(int)
    for i in {2, 3}:
        while n > 1 and n % i == 0:
            ret[i] += 1
            n //= i
    if n != 1:
        raise ValueError
    return ret


for _ in range(int(input())):
    n = int(input())
    if n == 1:
        print(0)
    else:
        try:
            f = prime_factors(n)
        except:
            print(-1)
            continue
        k = set(f.keys())
        if k != {2, 3} and k != {2} and k != {3}:
            print(-1)
        elif f[2] > f[3]:
            print(-1)
        else:
            steps = 0
            while True:
                if f[2] == f[3]:
                    print(steps + f[2])
                    break
                elif f[2] < f[3]:
                    steps += f[3] - f[2]
                    f[2] += f[3] - f[2]



