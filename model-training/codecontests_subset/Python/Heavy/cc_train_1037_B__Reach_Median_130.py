import sys
import math
import bisect

def solve(A, mval):
    n = len(A)
    m = (n - 1) // 2
    A.sort()
    #print('A: ' + str(A))
    ans = abs(A[m] - mval)
    A[m] = mval
    for i in range(m - 1, -1, -1):
        if A[i] > A[i+1]:
            ans += A[i] - A[i+1]
            A[i] = A[i+1]
    for i in range(m + 1, n):
        if A[i] < A[i-1]:
            ans += A[i-1] - A[i]
            A[i] = A[i-1]
    #print('A: ' + str(A))
    return ans

def main():
    n, m = map(int, input().split())
    A = list(map(int, input().split()))
    ans = solve(A, m)
    print(ans)

if __name__ == "__main__":
    main()
