#!/usr/bin/env python3
import unittest
import traceback
import pprint


def compress_list(a):
    x = []
    cur = a[0]
    num = 1
    for i in range(1, len(a)):
        if a[i] == cur:
            num += 1
        else:
            x.append([cur, num])
            cur = a[i]
            num = 1
    x.append([cur, num])
    return x


def solve(n, k, a):
    a = sorted(a)
    a = compress_list(a)
    min_ret = 200000000
    x = {0: [0 for i in range(0, 20)]}
    for cur, num in a:
        if num >= k:
            return 0
        idx = 0
        while cur > 0:
            if cur not in x:
                x[cur] = [0 for i in range(0, 20)]
            x[cur][idx] += num
            cur = cur // 2
            idx += 1
    for cur, ll in x.items():
        snum = 0
        scnt = 0
        for idx, num in enumerate(ll):
            if snum + num >= k:
                ret = scnt + (k -  snum) * idx
                min_ret = min(min_ret, ret)
                break
            snum += num
            scnt += num * idx
            if scnt >= min_ret:
                break
    # pprint.pprint(a)
    # pprint.pprint(x)
    return min_ret


class TestCase(unittest.TestCase):
    def test1(self):
        n = 5
        k = 3
        a = [2, 2, 3, 3, 5]
        self.assertEqual(solve(n, k, a), 1)

    def test2(self):
        n = 5
        k = 3
        a = [1, 2, 2, 4, 5]
        self.assertEqual(solve(n, k, a), 1)

    def test3(self):
        n = 5
        k = 3
        a = [1, 2, 3, 4, 5]
        self.assertEqual(solve(n, k, a), 2)

    def test4(self):
        n = 5
        k = 3
        a = [1, 2, 3, 3, 3]
        self.assertEqual(solve(n, k, a), 0)

    def test5(self):
        n = 10
        k = 4
        a = [4, 4, 8, 17, 25, 30, 99, 68, 89, 200]
        self.assertEqual(solve(n, k, a), 3)

    def test6(self):
        n = 1
        k = 1
        a = [1337]
        self.assertEqual(solve(n, k, a), 0)

if __name__ == "__main__":
    n, k = [int(i) for i in input().split()]
    a = [int(i) for i in input().split()]
    try:
        print(solve(n, k, a))
    except Exception as e:
        print(e, traceback.format_exc())
