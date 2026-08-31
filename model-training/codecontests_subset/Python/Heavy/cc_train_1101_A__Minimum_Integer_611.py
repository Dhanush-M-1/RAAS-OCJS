#	!/usr/bin/env python3
#	coding: UTF-8
#	Modified: <11/Jan/2019 08:18:10 PM>


#	✪ H4WK3yE乡
#	Mohd. Farhan Tahir
#	Indian Institute Of Information Technology (IIIT),Gwalior

#	Question Link
#
#

# ///==========Libraries, Constants and Functions=============///


import sys

inf = float("inf")
mod = 1000000007


def get_array(): return list(map(int, sys.stdin.readline().split()))


def get_ints(): return map(int, sys.stdin.readline().split())


def input(): return sys.stdin.readline()

# ///==========MAIN=============///


def main():
    from math import log, ceil, floor
    for tc in range(int(input())):
        l, r, d = get_ints()
        if d < l:
            print(d)
        elif d >= l and d <= r:
            print((d * floor(r / d)) + d)
        else:
            print(d)


if __name__ == "__main__":
    main()
