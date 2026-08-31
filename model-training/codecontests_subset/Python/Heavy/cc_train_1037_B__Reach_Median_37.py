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
    # 11 12 12 15 19 20 21
    n,s = isp()
    a = iar()
    a.sort()
    d = 0
    for i in range(n//2):
        if a[i] > s:
            d += a[i]-s
        elif a[n-1-i] < s:
            d += s - a[n-1-i]
    d += abs(a[n//2]-s)
    print(d)
