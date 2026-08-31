import sys
import math
import bisect

def solve(A):
    n = len(A)
    nl = 0
    nr = 0
    for i in range(n):
        if A[i] >= i:
            nl += 1
        else:
            break
    for i in range(n - 1, -1, -1):
        if A[i] >= n - 1 - i:
            nr += 1
        else:
            break
    if nl + nr - 1 >= n:
        return True
    else:
        return False

def main():
    for _ in range(int(input())):
        n = int(input())
        A = list(map(int, input().split()))
        if solve(A):
            print('Yes')
        else:
            print('No')

if __name__ == "__main__":
    main()
