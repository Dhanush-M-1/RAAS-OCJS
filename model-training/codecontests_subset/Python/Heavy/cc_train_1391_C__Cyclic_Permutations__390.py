from sys import stdin


def inp():
    return stdin.buffer.readline().rstrip().decode('utf8')


def itg():
    return int(stdin.buffer.readline())


def mpint():
    return map(int, stdin.buffer.readline().split())


# ############################## import
# from itertools import permutations as pm
#
# def check(tp):
#     # have a cycle
#     for i in range(len(tp) - 2):
#         # 2 1 3 or 3 1 2
#         if min(tp[i: i+3]) == tp[i+1]:
#             return True
#     return False
#
# for n in range(3, 10):
#     c = 0
#     for p in pm(range(n)):
#         if check(tuple(p)):
#             c += 1
#     print(c, end=", ")
# ############################## main
# def main():
# for case in range(1, itg()+1):


MOD = int(1e9) + 7

def factorial(n):
    r = 1
    for i in range(2, n+1):
        r = r*i % MOD
    return r

from math import ceil
def A059204(n):
    return factorial(n) - ceil(1 << n-1)
print(A059204(itg()) % MOD)
# Please check!
