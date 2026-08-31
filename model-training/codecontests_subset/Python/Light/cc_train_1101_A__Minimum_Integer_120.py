import sys
import math
from collections import defaultdict,deque

input = sys.stdin.readline
def inar():
    return [int(el) for el in input().split()]
def main():
    t=int(input())
    for _ in range(t):
        l,r,d=inar()
        if l <= d <= r:
            print(d*(r//d+1))
        else:
            print(d)


if __name__ == '__main__':
    main()



