import sys
import math
import bisect

def main():
    n, m = map(int, input().split())
    s = set()
    for i in range(n):
        A = list(map(int, input().split()))
        s = s | set(A[1:])
    if len(s) == m:
        print('YES')
    else:
        print('NO')

if __name__ == "__main__":
    main()
