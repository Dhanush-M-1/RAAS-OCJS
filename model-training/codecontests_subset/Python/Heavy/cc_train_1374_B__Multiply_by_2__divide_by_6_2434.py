################################################
#                                              #
#   author: raghav_0901 (Raghav Dalmia)        #
#   updated on: 22-09-2020,  7:41:57 pm IST   #
#                                              #
################################################

from math import *


def _in():
    return [int(x) for x in input().split(' ')]


if __name__ == "__main__":
    tt = int(input())
    for _ in range(tt):
        n = int(input())
        n2, n3, ans = 0, 0, 0
        while(n % 2 == 0):
            n2 = n2 + 1
            n = n // 2
        while(n % 3 == 0):
            n3 = n3 + 1
            n = n // 3
        if(n2 > n3 or n > 1):
            print(-1)
        else:
            ans = (n3 - n2) + n3
            print(ans)
