from collections import Counter
from collections import defaultdict
import math
import random
import heapq as hq
from math import sqrt
import sys
from functools import reduce


def input():
    return sys.stdin.readline().strip()


def iinput():
    return int(input())


def tinput():
    return input().split()


def rinput():
    return map(int, tinput())


def rlinput():
    return list(rinput())


mod = int(1e9)+7


def factors(n):
    return set(reduce(list.__add__,
                      ([i, n//i] for i in range(1, int(n**0.5) + 1) if n % i == 0)))


# ----------------------------------------------------


if __name__ == "__main__":
    for _ in range(iinput()):
        n ,m= rinput()
        s=input()
        p=rlinput()

        dp=[[0 for i in range(26)]for i in range(n)]
        dp[0][ord(s[0])-97]+=1
        for i in range(1,n):
            for j in range(26):
                dp[i][j]=dp[i-1][j]
            dp[i][ord(s[i])-97]+=1
        ans=[0]*26
        for i in range(m):
            for j in range(26):
                ans[j]+=dp[p[i]-1][j]
        for i in range(26):
            ans[i]+=dp[n-1][i]
        print(' '.join(map(str,ans)))
            


    
