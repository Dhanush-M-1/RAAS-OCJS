import math,string,itertools,fractions,heapq,collections,re,array,bisect
from itertools import chain, dropwhile, permutations, combinations
from collections import defaultdict


def main(n,x,h):
    s = 0
    last = -1e10
    for i in range(n):
        if i==0:
            s += 1
            last = x[i]
        elif i==n-1:
            s += 1
        elif last < x[i]-h[i]:
            s += 1
            last = x[i]
        elif x[i]+h[i] < x[i+1]:
            s += 1
            last = x[i] + h[i]
        else: # no cutting
            last = x[i]
    print(s)

def main_input(info=0):
    n = int(input())
    x = list(range(n))
    h = list(range(n))
    for i in range(n):
        x[i], h[i] = list(map(int,input().split()))
    main(n,x,h)

if __name__ == "__main__":
    main_input()
