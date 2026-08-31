# -*- coding: utf-8 -*-
"""
@Project : 牛客网
@File    : 2.py 
@Time    : 2018/6/10 18:23
@Author  : Koushiro

"""

if __name__ == "__main__":
    n, K = map(int, input().split())
    bac = list(map(int, input().split()))
    bac.sort()
    diff = [0 for i in range(n - 1)]
    count = 0
    future = 0
    for i in range(n - 1):
        if count == 0 and bac[i + 1] - bac[i] != 0:
            diff[i] = bac[i + 1] - bac[i]
        elif count > 0:
            diff[i] = future
            count -= 1
        else:
            j = i
            tmp = bac[j]
            # 操作有关数组下标的地方要尤其注意会不会导致下标越界，最好不要随意操作下标
            while bac[j] == tmp and j < n - 1:
                j += 1
            future = bac[j] - bac[i]
            diff[i] = future
            count = j - i - 1
    result = 1
    for i in range(n - 1):
        if diff[i] > K or diff[i] == 0:
            result += 1
    print(result)
