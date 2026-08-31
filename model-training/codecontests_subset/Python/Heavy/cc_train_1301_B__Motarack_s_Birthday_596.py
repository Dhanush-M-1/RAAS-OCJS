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
    n = Read.int()
    a = Read.list_int()

    new_a = []
    for i in range(n):
        if a[i] != -1 and (i == 0 or a[i - 1] != -1) and (i == n - 1 or a[i + 1] != -1):
            continue
        new_a.append(a[i])
    new_a = list(filter(lambda x: x != -1, new_a))
    if len(new_a) == 0:
        print('0 0')
        return
    mx = max(new_a)
    mn = min(new_a)
    k = round((mx + mn) / 2)
    m = 0
    for i in range(n - 1):
        p1 = a[i] if a[i] != -1 else k
        p2 = a[i + 1] if a[i + 1] != -1 else k
        r = math.fabs(p1 - p2)
        if r > m:
            m = int(r)
    print(m, k)


# query_count = 1
query_count = Read.int()
while query_count:
    query_count -= 1
    solve()
