# -*- coding: utf-8 -*-
# @Time    : 2019/3/22 23:27
# @Author  : LunaFire
# @Email   : gilgemesh2012@gmail.com
# @File    : B. Good String.py


def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        s = input()

        left_count, right_count = 0, 0
        for i in range(n):
            if s[i] == '<':
                left_count += 1
            else:
                break
        for i in range(n - 1, -1, -1):
            if s[i] == '>':
                right_count += 1
            else:
                break
        print(min(left_count, right_count))


if __name__ == '__main__':
    main()