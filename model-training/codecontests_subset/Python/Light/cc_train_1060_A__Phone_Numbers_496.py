import math
from collections import defaultdict

def input_ints():
    return list(map(int, input().split()))

def solve():
    n = int(input())
    s = input()
    n = len(s)
    c = s.count('8')
    for x in range(100):
        if x > c or 11 * x > n:
            print(x - 1)
            return

if __name__ == '__main__':
    solve()
