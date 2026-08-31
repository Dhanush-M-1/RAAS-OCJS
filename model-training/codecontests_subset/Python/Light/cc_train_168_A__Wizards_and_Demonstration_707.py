#!/usr/bin/env python3

def main():
    from math import ceil

    n, x, y = map(int, input().split())
    ans = ceil(y/100.0*n) - x

    print(ans if ans > 0 else 0)

if __name__ == "__main__":
    main()

