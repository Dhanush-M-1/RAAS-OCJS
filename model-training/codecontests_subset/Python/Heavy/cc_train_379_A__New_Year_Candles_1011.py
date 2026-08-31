from collections import deque, Counter, OrderedDict
from heapq import nsmallest, nlargest
from math import ceil,floor,log,log2,sqrt
def binNumber(n,size=1):
    return bin(n)[2:].zfill(size)

def gcd(a,b):
    if a == 0:
        return b
    return gcd(b%a,a)

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
    a,b = isp()
    k = a
    rem = 0
    while a != 0:

        rem += a%b
        if rem >= b:
            #k += 1
            rem -= b
            a = a//b + 1
        else:
            a = a//b
        
        
        
        k += a
    print(k)
    
        