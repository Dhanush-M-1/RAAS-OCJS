#                          JAI SHREE RAM

import math; from collections import *
import sys; from functools import reduce

def get_ints(): return map(int, input().strip().split())
def get_list(): return list(get_ints())
def getlistofstring(): return list(input().strip().split())
def printxsp(*args): return print(*args, end="")
def printsp(*args): return print(*args, end=" ")

UGLYMOD = int(1e9)+7; SEXYMOD = 998244353; MAXN = int(1e5)

# sys.setrecursionlimit(10**6)
# sys.stdin=open("input.txt","r");sys.stdout=open("output.txt","w")
# import bisect

# for _testcases_ in range(int(input())):
alice =[];  bob = [];  both = [];
n , k = get_ints()
for i in range(n):
    t, a, b = get_ints()
    if a & b:
        both.append(t)
    elif a == 1:
        alice.append(t)
    elif b == 1:
        bob.append(t)
if len(both) + min(len(alice), len(bob)) < k:
    ans = -1
else:
    bob = sorted(bob)
    alice = sorted(alice)
    both = sorted(both)
    ai = bi = xi = 0

    ans = 0
    while k:
        try: X = both[xi]
        except: X = float('inf')
        try: A = alice[ai]
        except: A = float('inf')
        try: B = bob[bi]
        except: B = float('inf')
        # print(alice, bob, both)
        # print(A, B, X)
        if (A == float('inf')) or (B == float('inf')):
            ans += X
            xi += 1
        elif X == float('inf'):
            ans += A + B
            ai += 1
            bi += 1
        elif A + B < X:
            ans += A + B
            ai += 1
            bi += 1
        else:
            ans += X
            xi += 1
        k -= 1
print(ans)

        



'''
>>> COMMENT THE STDIN!! CHANGE ONLINE JUDGE !!
THE LOGIC AND APPROACH IS MINE @luctivud ( UDIT GUPTA )
Link may be copy-pasted here if it's taken from other source.
DO NOT PLAGIARISE.
>>> COMMENT THE STDIN!! CHANGE ONLINE JUDGE !!
'''