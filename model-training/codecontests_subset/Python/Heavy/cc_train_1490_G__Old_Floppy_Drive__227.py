from sys import stdin
from math import ceil
from bisect import bisect_left as bl

input = stdin.readline


def greater(num, arr):
    ind = bl(arr, num)
    return arr[ind]


for test in range(int(input())):
    n, m = map(int, input().strip().split())
    lst = list(map(int, input().strip().split()))
    x = list(map(int, input().strip().split()))
    dct = {}
    s = 0
    ans = [-1] * m
    temp = 0
    for i in range(n):
        s += lst[i]
        temp = max(temp, s)
        try:
            dct[temp]
        except KeyError:
            dct.update({s: i})
    sum_lst = list(dct.keys())
    # print(s, dct, sum_lst)
    s_max = sum_lst[-1]
    if s_max > 0:
        for i in range(m):
            if x[i] <= s_max:
                num = greater(x[i], sum_lst)
                ans[i] = dct[num]
            else:
                if s > 0:
                    store = ceil((x[i] - s_max) / s)
                    check = x[i] - store * s
                    num = greater(check, sum_lst)
                    ans[i] = dct[num] + store * n
                    # print(store, check, ind)
    print(*ans)
