# cook your dish here
from sys import stdin, stdout
import math
from itertools import permutations, combinations
from collections import defaultdict
from bisect import bisect_left 
from bisect import bisect_right
 
def L():
    return list(map(int, input().split()))
 
def In():
    return map(int, input().split())
 
def I():
    return int(input())
 
P = 1000000007
def main():
    for t in range(I()):
        n = I()
        lis = [0, 0]
        if n == 1:
            print(0)
        else:
            while n%2 == 0:
                lis[0] += 1
                n//= 2
            while n%3 == 0:
                lis[1] += 1
                n //= 3
            if n > 1 or lis[0] > lis[1]:
                print(-1)
            else:
                print(lis[1]+lis[1]-lis[0])
            
    
    
if __name__ == '__main__':
    main()
