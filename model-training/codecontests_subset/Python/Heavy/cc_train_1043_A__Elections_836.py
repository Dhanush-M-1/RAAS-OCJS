
# -*- coding: utf-8 -*-
# @Date    : 2018-11-14 16:14:52
# @Author  : raj lath (oorja.halt@gmail.com)
# @Link    : link
# @Version : 1.0.0

from sys import stdin

max_val=int(10e12)
min_val=int(-10e12)

def read_int()     : return int(stdin.readline())
def read_ints()    : return [int(x) for x in stdin.readline().split()]
def read_str()     : return input()
def read_strs()    : return [x for x in stdin.readline().split()]


n = read_int()
votes = read_ints()
vote_sum = sum(votes)
max_vote = max(votes)
ans = max(max_vote, 2 * vote_sum // n + 1)
print(ans)