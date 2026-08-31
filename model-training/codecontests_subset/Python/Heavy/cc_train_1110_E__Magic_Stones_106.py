# -*- coding: utf-8 -*-
# @Time    : 2019/2/7 22:53
# @Author  : LunaFire
# @Email   : gilgemesh2012@gmail.com
# @File    : E. Magic Stones.py


def main():
    n = int(input())
    c = list(map(int, input().split()))
    t = list(map(int, input().split()))

    cd = [c[i + 1] - c[i] for i in range(n - 1)]
    td = [t[i + 1] - t[i] for i in range(n - 1)]

    cd.sort()
    td.sort()

    if c[0] != t[0] or c[-1] != t[-1]:
        print('No')
    else:
        if cd == td:
            print('Yes')
        else:
            print('No')


if __name__ == '__main__':
    main()
