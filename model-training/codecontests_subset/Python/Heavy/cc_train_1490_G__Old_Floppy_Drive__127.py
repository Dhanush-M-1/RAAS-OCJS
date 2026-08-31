#!/usr/bin/env python3
# set vim: fdm=marker sw=4 ts=4 et

import bisect

# {{{ IntervalTree
class IntervalTree:
    @staticmethod
    def get_depth(n):
        depth = 0
        i = 1
        while i < n:
            depth += 1
            i <<= 1
        return depth

    def __init__(self, n):
        self.n = n
        self.depth = IntervalTree.get_depth(n)
        self.top = 1 << self.depth
        self.v = []
        for i in range(self.top + self.n):
            self.v.append(None) # max value

    def add(self, pos, value):
        assert pos < self.n
        idx = 1
        mask = 1 << (self.depth - 1)
        while idx < len(self.v):
            if self.v[idx] is None or self.v[idx] < value:
                self.v[idx] = value

            idx <<= 1
            if (pos & mask) != 0:
                idx += 1
            mask >>= 1

    def get_impl(self, idx, l, r, v):
        if r - l == 1:
            return l

        idx <<= 1
        m = (l + r) // 2

        if self.v[idx] >= v:
            return self.get_impl(idx, l, m, v)
        else:
            return self.get_impl(idx + 1, m, r, v)

    def get(self, v):
        if self.v[1] < v:
            return self.n
        return self.get_impl(1, 0, self.top, v)
# }}}


for _ in range(int(input())):
    n, m = map(int, input().split())
    a = [int(i) for i in input().split()]
    x = [int(i) for i in input().split()]

    b = []
    if n == 1:
        for x_i in x:
            if a[0] <= 0:
                b.append(-1)
            else:
                b.append((x_i + a[0] - 1) // a[0] - 1)
    else:
        sum_a = sum(a)

        s = 0
        it = IntervalTree(n)
        for i in range(n):
            s += a[i]
            it.add(i, s)
        max_s_i = it.v[1]

        for x_i in x:
            pos = it.get(x_i)
            if pos < n:
                b.append(pos)
                continue

            if sum_a <= 0:
                b.append(-1)
                continue

            b_i = (x_i - max_s_i) // sum_a
            x_i -= sum_a * b_i
            b_i *= n

            while True:
                pos = it.get(x_i)
                if pos == n:
                    b_i += n
                    x_i -= sum_a
                else:
                    b_i += pos
                    break
            b.append(b_i)

    print(" ".join([str(i) for i in b]))
