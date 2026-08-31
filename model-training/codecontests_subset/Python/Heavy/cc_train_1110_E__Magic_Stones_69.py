# Useful data structures
from collections import Counter, defaultdict, deque, namedtuple

# Most useful math functions
from math import gcd

# For sys.std*, sys.argv etc...
import sys

def read_ints():
    return [int(token) for token in input().split()]

def read_tokens():
    return input().split()

def differences(a):
    return (a[0], a[-1], sorted(x - y for (x, y) in zip(a, a[1:])))

def main():
    N = read_ints()[0]
    c = differences(read_ints())
    t = differences(read_ints())
    result = "Yes" if c == t else "No"
    print(result)

if __name__ == '__main__':
    main()
