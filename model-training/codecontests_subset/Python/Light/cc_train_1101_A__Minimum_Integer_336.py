# -*- coding: utf-8 -*-
# @Time    : 2019/1/11 22:37
# @Author  : LunaFire
# @Email   : gilgemesh2012@gmail.com
# @File    : A. Minimum Integer.py


def main():
    query_num = int(input())
    for _ in range(query_num):
        l, r, d = map(int, input().split())
        if l > d:
            ret = d
        else:
            ret = r // d * d + d
        print(ret)


if __name__ == '__main__':
    main()
