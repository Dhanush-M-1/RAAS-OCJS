import sys
import math
import collections

def set_debug(debug_mode=False):
    if debug_mode:
        fin = open('input.txt', 'r')
        sys.stdin = fin


def int_input():
    return list(map(int, input().split()))


if __name__ == '__main__':
    # set_debug(True)

    t = int(input())

    for ti in range(1, t + 1):
        # n = int_input()
        n = int(input())

        if n == 1:
            print(0)
            continue

        if n % 3 != 0:
            print(-1)
        else:
            res = 0
            while n > 1:
                if n % 6 == 0:
                    n = n // 6
                    res += 1
                else:
                    if n % 3 != 0:
                        print(-1)
                        break
                    else:
                        n = n * 2
                        res += 1
            else:
                print(res)


