
# -*- coding: utf-8 -*-
# @Date    : 2019-01-22 16:44:36
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


need = input()
nb_barks = int(input())
maybe = []
ans = "NO"
for _ in range(nb_barks):
    curr = input()
    if need == curr:
        ans = "YES"
        break
    else:
        maybe.append(curr)
#print(maybe, "First")
if ans != "YES":
    for i in maybe:
        if i[1] == need[0]:
            for j in maybe:
                if j[0] == need[1]:
                    ans = "YES"
                    break
print(ans)



