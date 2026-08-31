import sys
import math
import bisect

def main():
    n = int(input())
    A = list(int(a) for a in input())
    m = 0
    for a in A:
        if a == 8:
            m += 1
    max_val = 0
    for i in range(m + 1):
        if i * 11 <= n:
            val = i
            max_val = max(max_val, val)
    print(max_val)

if __name__ == "__main__":
    main()
