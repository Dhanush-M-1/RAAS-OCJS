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
    for t in range(I()):
        n = I()
        arr = L()
        if arr[0]+arr[1] <= arr[n-1]:
            print(1, 2, n)
        else:
            print(-1)
    
    
if __name__ == '__main__':
    main()
