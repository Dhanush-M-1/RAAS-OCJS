from sys import stdin, setrecursionlimit, stdout
#setrecursionlimit(1000000)
from collections import deque
from math import sqrt, floor, ceil, log, log2, log10, pi, gcd, sin, cos, asin
from heapq import heapify, heappop, heappush, heappushpop, heapreplace
def ii(): return int(stdin.readline())
def fi(): return float(stdin.readline())
def mi(): return map(int, stdin.readline().split())
def fmi(): return map(float, stdin.readline().split())
def li(): return list(mi())
def si(): return stdin.readline().rstrip()
def lsi(): return list(si())
#mod=1000000007
res=['YES', 'NO']
############# CODE STARTS HERE #############

p=[1, 6, 36, 216, 1296, 7776, 46656, 279936, 1679616, 10077696, 60466176, 362797056, 2176782336, 13060694016, 78364164096, 470184984576, 2821109907456, 16926659444736, 101559956668416, 609359740010496, 3656158440062976, 21936950640377856, 131621703842267136, 789730223053602816, 4738381338321616896, 28430288029929701376, 170581728179578208256]
test_case=ii()
while test_case:
    test_case-=1


    n=ii()
    c=0
    i=0
    while i<27:
        if p[i]==n:
            break
        elif p[i]>n:
            n+=n
            c+=1
        else:
            i+=1
    print(c+i if i<27 else -1)