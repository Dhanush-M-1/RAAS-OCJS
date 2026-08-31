import math
import collections
import sys


def inpu():
    return input().split(' ')


def inti(a):
    for i in range(len(a)):
        a[i] = int(a[i])
    return a


def inp():
    a = inpu()
    a = inti(a)
    return a


a = inp()
n, k = a[0], a[1]
bob = []
alice = []
common = []
for i in range(n):
    a = inp()
    if a[1] == 1 and a[2] == 1:
        common.append(a[0])
    elif a[1] == 1 and a[2] == 0:
        bob.append(a[0])
    elif a[1] == 0 and a[2] == 1:
        alice.append(a[0])
bob.sort()
alice.sort()
common.sort()
l1 = len(bob)
l2 = len(alice)
l3 = len(common)
if l1+l3 < k or l2 + l3 < k:
    print(-1)
    exit(0)
bobptr = 0
aliceptr = 0
commonptr = 0
cost = 0
while k > 0:
    if (commonptr >= l3) or (bobptr < l1 and aliceptr < l2 and commonptr < l3 and bob[bobptr] + alice[aliceptr] < common[commonptr]):
        cost = cost + bob[bobptr] + alice[aliceptr]
        k -= 1
        bobptr += 1
        aliceptr += 1
    else:
        cost = cost + common[commonptr]
        commonptr += 1
        k -= 1

print(cost)
