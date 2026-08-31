# alpha = "abcdefghijklmnopqrstuvwxyz"
# prime = 1000000007#998244353 
# INF = 10000

# from sys import stdout
# from heapq import heappush, heappop
# from collections import defaultdict
# from collections import deque 
# import bisect 

# from math import sqrt    
# from math import gcd
# from math import log2

# with open('input.in','r') as Reader:
#     with open('output.out','w') as out:
        # n = int(Reader.readline())

    
# print(len(arr))
# print(arr[:10])


t = int(input())
for test in range(t):
    n = int(input())
    arr = list(map(int, input().split()))
    D = set()
    count = 0
    ans = "YES"
    for i in arr:
        a = (i + count)%n
        if a in D:
            ans = "NO"
            break
        D.add(a)
        count += 1
    
    print(ans)