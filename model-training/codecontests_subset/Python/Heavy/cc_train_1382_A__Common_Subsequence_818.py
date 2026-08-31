# Let's hack this code.

from sys import stdin, stdout
import math
from itertools import permutations, combinations
from collections import defaultdict
from bisect import bisect_left 

mod = 1000000007

def L():
    return list(map(int, stdin.readline().split()))

def In():
    return map(int, stdin.readline().split())

def I():
    return int(stdin.readline())

def printIn(ob):
    return stdout.write(str(ob)+'\n')

def powerLL(n, p):
    result = 1
    while (p):
        if (p&1):
            result = result * n % mod
        p = int(p / 2)
        n = n * n % mod
    return result

#--------------------------------------

def myCode():
    n,m = In()
    a = L()
    b = L()
    if n<=m:
        for i in range(n):
            if a[i] in b:
                print('YES')
                print(1,a[i])
                return
    else:
        for i in range(m):
            if b[i] in a:
                print('YES')
                print(1,b[i])
                return
    print("NO")
            
def main():
    for t in range(I()):
        myCode()
if __name__ == '__main__':
    main()