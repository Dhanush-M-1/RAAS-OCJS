from collections import defaultdict, deque
from itertools import permutations
from sys import stdin,stdout
from bisect import bisect_left, bisect_right
from copy import deepcopy
#from random import randint

int_input=lambda : int(stdin.readline())
string_input=lambda : stdin.readline()
multi_int_input =lambda : map(int, stdin.readline().split())
multi_input = lambda : stdin.readline().split()
list_input=lambda : list(map(int,stdin.readline().split()))
string_list_input=lambda: list(string_input())
MOD = pow(10,9)+7

test = int_input()

for _ in range(test):
    #print("Hello")
    a,b,c = multi_int_input()
    ball = 0
    while c>1:
        if b>0:
            b-=1
            c-=2
            ball+=3
        else:
            break


    while b>1:
        if a>0:
            a-=1
            b-=2
            ball+=3
        else:
            break
    
    print(ball)