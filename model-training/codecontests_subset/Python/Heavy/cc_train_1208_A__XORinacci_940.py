# alpha = "abcdefghijklmnopqrstuvwxyz"
# prime = 998244353 
# INF = 1000000000000000000000

# from sys import stdout
# from heapq import heappush, heappop
# from collections import defaultdict
# from collections import deque  

# from math import sqrt    
# from math import gcd
# from math import log2

t = int(input())

for test in range(t):
    # n = int(input())
    a, b, n = list(map(int, input().split()))
    if n%3==0:
        print(a)
    elif n%3==1:
        print(b)
    else:
        print(a^b)
