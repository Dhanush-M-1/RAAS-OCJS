
# -*- coding: utf-8 -*-
# @Date    : 2018-09-03 08:46:01
# @Author  : raj lath (oorja.halt@gmail.com)
# @Link    : http://codeforces.com/contest/1037/problem/B
# @Version : 1.0.0

import os
from sys import stdin

max_val=int(10e12)
min_val=int(-10e12)

def read_int()     : return int(stdin.readline())
def read_ints()    : return [int(x) for x in stdin.readline().split()]
def read_str()     : return input()
def read_strs()    : return [x for x in stdin.readline().split()]
def read_str_list(): return [x for x in stdin.readline().split().split()]

nb_elemets, value_needed = read_ints()
elements = sorted(read_ints())
mid = nb_elemets//2
ans = abs(elements[mid] - value_needed)
ans += sum( max(0, (a - value_needed)) for a in elements[:mid] )
ans += sum( max(0, (value_needed - a)) for a in elements[mid+1:] )
print(ans)



