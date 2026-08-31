import math


class Read:
    @staticmethod
    def string():
        return input()

    @staticmethod
    def int():
        return int(input())

    @staticmethod
    def list(sep=' '):
        return input().split(sep)

    @staticmethod
    def list_int(sep=' '):
        return list(map(int, input().split(sep)))


def solve():
    alp = 'abcdefghijklmnopqrstuvwxyz'
    n, m = Read.list_int()
    s = Read.string()
    p = Read.list_int()

    p.sort()
    p.reverse()

    t = {}
    for i in p:
        i_lcl = i - 1
        if i_lcl in t:
            t[i_lcl] += 1
        else:
            t[i_lcl] = 1
    t[n - 1] = 1

    res = {}
    k = 0
    for i in range(n - 1, -1, -1):
        if i in t:
            k += t[i]
        if s[i] in res:
            res[s[i]] += k
        else:
            res[s[i]] = k

    res_s = []
    for i in alp:
        res_s.append(str(res[i]) if i in res else '0')
    print(' '.join(res_s))

# query_count = 1
query_count = Read.int()
while query_count:
    query_count -= 1
    solve()

# 2 1 1 2 9 2 2 2 5 2 2 2 1 1 5 4 11 8 2 7 5 1 10 1 5 2
# 2 1 1 2 9 2 2 2 5 2 2 2 1 1 5 4 1 1 8 2 7 5 1 1 0 1 5 2