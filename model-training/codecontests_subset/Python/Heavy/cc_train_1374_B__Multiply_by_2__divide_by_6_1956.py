from collections import Counter
import sys
input=sys.stdin.readline


def add_target(n):
    primes = Counter()
    for i in [2, 3]:
        while n%i==0:
            primes[i] += 1
            n //= i
        if not n:
            break
    if n>1:
        return False
    return primes

def solve():
    t = int(input())
    for _ in range(t):
        n = int(input())
        d = add_target(n)
        if d==False:
            print(-1)
            continue
        used = set(d.keys())
        if n==1:
            print(0)
        elif used=={2,3} or used=={3}:
            y = d[3]
            x = y-d[2]
            if x>=0 and y>=0:
                print(x+y)
            else:
                print(-1)
        else:
            print(-1)


solve()
