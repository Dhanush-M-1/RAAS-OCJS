#from sys import maxsize as inf
from collections import Counter as cnt, defaultdict as dic
#from decimal import Decimal as de
#from statistics import median, mode, mean
#from math import pow, log, floor, sqrt, comb, ceil, gcd
#from copy import deepcopy as dc
#from heapq import heappush, heapify, heappop

iin = lambda: int(input())
lin = lambda: list(map(int, input().rstrip().split()))

TEST_CASES = True
def main():
    n = iin()
    mat = [input() for i in range(n)]
    
    if int(mat[1][0])+int(mat[0][1]) == 0:
        if int(mat[n-2][n-1])+int(mat[n-1][n-2]) == 0:
            print(2)
            print(n,n-1)
            print(n-1,n)
        elif int(mat[n-2][n-1])+int(mat[n-1][n-2]) == 1:
            print(1)
            if int(mat[n-1][n-2]) == 0:
                print(n,n-1)
            else:
                print(n-1,n)
        else:
            print(0)
        return
    elif int(mat[1][0])+int(mat[0][1]) == 2:
        if int(mat[n-2][n-1])+int(mat[n-1][n-2]) == 0:
            print(0)
        elif int(mat[n-2][n-1])+int(mat[n-1][n-2]) == 1:
            print(1)
            if int(mat[n-1][n-2]) == 1:
                print(n,n-1)
            else:
                print(n-1,n)
        else:
            print(2)
            print(n,n-1)
            print(n-1,n)
        return
    else:
        
        if int(mat[n-1][n-2]) + int(mat[n-2][n-1]) == 0:
            print(1)
            if mat[0][1] == '0':
                print(1,2)
            else:
                print(2,1)
        elif int(mat[n-1][n-2]) + int(mat[n-2][n-1]) == 2:
            print(1)
            if mat[0][1] == '1':
                print(1,2)
            else:
                print(2,1)
        else:     
            majority = int(mat[n-2][n-2])
            print(2)
            if int(mat[n-1][n-2]) == majority:
                print(n-1,n)
            else:
                print(n,n-1)
            if int(mat[0][1]) == majority:
                print(1,2)
            else:
                print(2,1)
        return
    
# START
if not TEST_CASES: main()
else: [main() for _ in range(int(input()))]

























