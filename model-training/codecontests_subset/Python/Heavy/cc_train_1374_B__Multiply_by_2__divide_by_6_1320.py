from sys import stdin
from math import *
from random import randint
from collections import deque
def splt(): return map(int, stdin.readline().split())


a = 1
ara = {1: 0}
for i in range(1, 100000, 1):
    ara[a * 6] = i
    a = a * 6
    if a > 1000000000000000000000:
        break


test = int(input())
for i in range(test):
    n = int(input())
    flag = 0
    for j in range(1000000000):
        if ara.get(n) or n == 1:
            print(j + ara[n])
            flag = 1
            break
        n = n * 2
        if n > 10000000000000000000:
            break

    if flag == 0:
        print(-1)




