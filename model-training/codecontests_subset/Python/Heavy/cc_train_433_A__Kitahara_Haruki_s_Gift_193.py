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
    arr = L()
    y1, x1 = 0, 0
    v1, v2 = 0, 0
    c1= 0
    for i in range(n):
        if arr[i] == 100:
            c1 += 1
            y1 += 1 
        if arr[i] == 200:
            x1 += 2 
        if x1 == 4:
            v1 += 2 
            v2 += 2
            x1 = 0 
        if y1 == 4:
            c1 = 1
            v1 += 2 
            v2 += 2 
            y1 = 0 
    if x1 == 2:
        if y1%2 != 0 :
            print('NO')
        elif y1 == 2:
            v1 += 2 
            v2 += 2 
            print('YES')
        else:
            if c1:
                print('YES')
            else:
                print('NO')
    elif x1 == 0 :
        if y1%2 != 0:
            print('NO')
        else:
            print('YES')
if __name__ == '__main__':
    main()