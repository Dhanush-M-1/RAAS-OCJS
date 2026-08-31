import sys
import math
import bisect

def solve(A):
    n = len(A)
    #print('A: %s' % str(A))
    for i in range(n):
        if A[i][0] < A[i][1]:
            return False
        if i:
            dx = A[i][0] - A[i-1][0]
            dy = A[i][1] - A[i-1][1]
            if dx < 0:
                return False
            if dy < 0:
                return False
            if dx < dy:
                return False
    return True

def main():
    for _ in range(int(input())):
        n = int(input())
        A = []
        for i in range(n):
            A.append(list(map(int, input().split())))
        if solve(A):
            print('YES')
        else:
            print('NO')

if __name__ == "__main__":
    main()
