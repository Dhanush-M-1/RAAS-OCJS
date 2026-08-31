import sys
import math
import bisect

def solve(A, m):
    n = len(A)
    B = [0] * n
    for i in range(n):
        if i == 0:
            B[i] = 1
        else:
            B[i] = B[i-1] + i + 1
    '''
    print('A: ' + str(A))
    print('m: ' + str(m))
    print('B: ' + str(B))
    '''
    p = bisect.bisect_left(B, m)
    if p:
        m -= B[p-1]
    '''
    print('p: ' + str(p))
    print('m: ' + str(m))
    '''
    return A[m-1]

def main():
    n, m = map(int, input().split())
    A = list(map(int, input().split()))
    print(solve(A, m))

if __name__ == "__main__":
    main()
