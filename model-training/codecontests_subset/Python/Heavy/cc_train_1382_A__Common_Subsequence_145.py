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
        n, m = In()
        arr1 = L()
        arr2 = L()
        flag = 0
        v = 0
        for i in arr1:
            for j in arr2:
                if i == j:
                    flag = 1 
                    v = i 
                    break 
        if flag:
            print("YES")
            print(1, v)
        else:
            print("NO")
        
    
    
if __name__ == '__main__':
    main()
