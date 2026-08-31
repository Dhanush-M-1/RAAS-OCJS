import sys
import math
import bisect

def main():
    ans = 0
    r = 0
    n, m = map(int, input().split())
    while n:
        ans += n
        r += n
        n, r = (r // m, r % m)
    print(ans)

if __name__ == "__main__":
    main()
