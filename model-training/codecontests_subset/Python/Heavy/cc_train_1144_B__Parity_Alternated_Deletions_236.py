import sys
import math
import bisect
import itertools
import random

def main():
    n = int(input())
    A = []
    B = []
    for a in list(map(int, input().split())):
        if a % 2 == 0:
            A.append(a)
        else:
            B.append(a)
    A.sort(reverse=True)
    B.sort(reverse=True)
    '''
    print('A: ' + str(A))
    print('B: ' + str(B))
    '''
    n = len(A)
    m = len(B)
    if n == m:
        print(0)
    elif n > m:
        print(sum(A[m+1:]))
    else:
        print(sum(B[n+1:]))

if __name__ == "__main__":
    main()
