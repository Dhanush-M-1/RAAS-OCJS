from collections import defaultdict, deque
from itertools import permutations
from sys import stdin,stdout
from bisect import bisect_left, bisect_right
from copy import deepcopy

int_input=lambda : int(stdin.readline())
string_input=lambda : stdin.readline()
multi_int_input =lambda : map(int, stdin.readline().split())
multi_input = lambda : stdin.readline().split()
list_input=lambda : list(map(int,stdin.readline().split()))
string_list_input=lambda: list(string_input())
MOD = pow(10,9)+7

n,m = multi_int_input()

a = list_input()
b = list_input()

a.sort()
b.sort()

possible_x = set([])
ans = []
for i in range(n):
    possible_x.add((b[0] - a[i])%m)

for x in possible_x:
    temp = []
    for i in range(n):
        temp.append((a[i]+x)%m)
    temp.sort()
    if temp == b:
        ans.append(x)

print(min(ans))
