import sys
import math
import bisect

def solve(n, x, y):
    ans = 0
    while (x + ans) * 100  < y * n:
        ans += 1
    return ans

def main():
    n, x, y = map(int, input().split())
    print(solve(n, x, y))

if __name__ == "__main__":
    main()
