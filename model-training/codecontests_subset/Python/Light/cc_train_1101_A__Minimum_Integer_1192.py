import sys
import math
import bisect

def solve(l, r, d):
    if l > d:
        return d
    val = r + 1
    ans = (val + d - 1) // d * d
    return ans

def main():
    for _ in range(int(input())):
        l, r, d = map(int, input().split())
        print(solve(l, r, d))

if __name__ == "__main__":
    main()
