import sys
import math
import bisect
import itertools
import random
import re

def solve(A, s):
    if s in A:
        return True
    n = len(A)
    for i in range(n):
        for j in range(n):
            if A[i][1] + A[j][0] == s:
                return True
    return False

def main():
    s = input()
    A = []
    for _ in range(int(input())):
        A.append(input())
    if solve(A, s):
        print('YES')
    else:
        print('NO')

if __name__ == "__main__":
    main()
