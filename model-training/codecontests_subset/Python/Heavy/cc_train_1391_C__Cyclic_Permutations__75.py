# cook your dish here
from sys import stdin, stdout
import math
from itertools import permutations, combinations
from collections import defaultdict
from bisect import bisect_left 
from bisect import bisect_right
 
def L():
    return list(map(int, stdin.readline().split()))
 
def In():
    return map(int, stdin.readline().split())
 
def I():
    return int(stdin.readline())
 
P = 1000000007
def main():
    n = I()
    val = 1
    c = 1
    for i in range(1, n+1):
        val *= i
        val %= P
        if i != n:
            c *= 2
            c %= P
    if val > c:
        print(val-c)
    else:
        print(P+val-c)
    
if __name__ == '__main__':
    main()
