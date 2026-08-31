import sys
import math
import bisect
import itertools

def main():
    n, m = map(int, input().split())
    A = list(map(int, input().split()))
    min_val = 10 ** 18
    for a in A:
        if a and m % a == 0:
            val = m // a
            min_val = min(min_val, val)
    print(min_val)

if __name__ == "__main__":
    main()
