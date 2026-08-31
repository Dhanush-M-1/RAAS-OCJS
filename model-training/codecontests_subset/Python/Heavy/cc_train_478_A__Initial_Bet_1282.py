
# -*- coding: utf-8 -*-
# @Date    : 2018-09-28 09:18:53
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

bets = read_ints()
each, res = divmod(sum(bets), len(bets))
if res == 0 and each != 0:
    print(each)
else:
    print(-1)    


