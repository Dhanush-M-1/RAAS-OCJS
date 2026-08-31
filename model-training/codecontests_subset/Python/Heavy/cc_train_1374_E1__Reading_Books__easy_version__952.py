import sys, math
input = sys.stdin.readline

def getInts():
    return [int(s) for s in input().split()]

def getInt():
    return int(input())

def getStrs():
    return [s for s in input().split()]

def getStr():
    return input().strip()

def listStr():
    return list(input().strip())

import collections as col
import math

def solve():
    N, K = getInts()
    A = []
    B = []
    AB = []
    for n in range(N):
        T, a, b = getInts()
        if a and b:
            AB.append(T)
        elif a:
            A.append(T)
        elif b:
            B.append(T)
    ans = 0
    A.sort(reverse=True)
    B.sort(reverse=True)
    AB.sort(reverse=True)
    def getNextBook():
        if (not A or not B) and not AB:
            return -1
        if (not A or not B) or (AB and AB[-1] <= A[-1]+B[-1]):
            return AB.pop()
        return A.pop()+B.pop()
    count = 0
    while True:
        x = getNextBook()
        if x < 0:
            return -1
        ans += x
        count += 1
        if count == K:
            return ans


    
#for _ in range(getInt()):
print(solve())
    

