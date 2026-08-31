from collections import deque, Counter, OrderedDict
from heapq import nsmallest, nlargest
def binNumber(n,size):
    return bin(n)[2:].zfill(size)

def gcd(a,b):
    if a == 0:
        return b
    return gcd(b%a,a)

#  =========     /\       /|    |====/|
#      |        /  \       |    |   / |
#      |       /____\      |    |  /  |
#      |      /      \     |    | /   |
#  ========= /        \  =====  |/====|  
#  code
if __name__ == "__main__":
    a = list(map(int,input().split()))
    if sum(a)%len(a) == 0 and a != [0]*len(a):
        print(sum(a)//len(a))
    else:
        print(-1)