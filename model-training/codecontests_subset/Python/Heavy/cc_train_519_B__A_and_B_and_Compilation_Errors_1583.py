from collections import deque, Counter, OrderedDict
from heapq import nsmallest, nlargest
from math import ceil,floor,log,log2,sqrt,gcd,factorial
def binNumber(n,size=1):
    return bin(n)[2:].zfill(size)

def iar():
    return list(map(int,input().split()))

def ini():
    return int(input())

def isp():
    return map(int,input().split())

def sti():
    return str(input())

#  =========     /\       /|    |====/|
#      |        /  \       |    |   / |
#      |       /____\      |    |  /  |
#      |      /      \     |    | /   |
#  ========= /        \  =====  |/====|  
#  code

if __name__ == "__main__":
    n = ini()
    a1 = iar()
    a2 = iar()
    a3 = iar()
    a1.sort()
    a2.sort()
    a3.sort()
    v = 0
    for i in range(n-1):
        if a1[i] != a2[i]:
            print(a1[i])
            v = 1
            break
    if v == 0:
        print(a1[n-1])
    v = 0
    for i in range(n-2):
        if a2[i] != a3[i]:
            print(a2[i])
            v = 1
            break
    if v == 0:
        print(a2[n-2])
