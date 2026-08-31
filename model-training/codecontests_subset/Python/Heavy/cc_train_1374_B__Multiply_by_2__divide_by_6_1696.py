import math
import os
import random
import re
import sys
import collections
def prime_factors(n):
    i = 2
    factors = []
    while i * i <= n and i<=3:
        if n % i:
            i += 1
        else:
            n //= i
            factors.append(i)
    if n > 1:
        factors.append(n)
    return factors

def solve():
    for _ in range(int(input())):
        n=int(input())
        if n==1:
            print(0)
            continue
        else:
            l=prime_factors(n)
            c=dict(collections.Counter(l))
            #print(c)
            if 2 not in c and 3 not in c:
                print(-1)
            elif 2 in c and 3 not in c:
                print(-1)
            elif 3 in c and 2 not in c:
                n=n*(2**c[3])
                n=n//(6**c[3])
                if n==1:
                    print(c[3]*2)
                else:
                    print(-1)
            else:
                if c[2]>c[3]:
                    print(-1)
                else:
                    n=n*(2**(c[3]-c[2]))
                    n=n//(6**c[3])
                    if n==1:
                        print((c[3]-c[2])+c[3])
                    else:
                        print(-1)
            
if __name__=="__main__":
    solve()


