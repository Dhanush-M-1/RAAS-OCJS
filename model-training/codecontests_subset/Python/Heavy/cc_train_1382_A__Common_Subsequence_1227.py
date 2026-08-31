# Author : Mradul Tiwari

import heapq as hp
import collections
import bisect
import math
import re


def unpack(func=int):
    return map(func, input().split())


def l_unpack(func=int):
    """list unpack"""
    return list(map(func, input().split()))


def s_unpack(func=int):
    """sorted list unpack"""
    return sorted(map(func, input().split()))


def ml_unpack(n):  # multiple line unpack
    """list of n integers passed on n line, one on each"""
    return [int(input()) for i in range(n)]


def range_n():
    return range(int(input()))


def counter(a):
    d = {}
    for x in a:
        if x in d:
            d[x] += 1
        else:
            d[x] = 1
    return d


def getint():
    return int(input())


def lcs_bottom_up_subsequence(s1,s2,n1,n2):
    t=[[0]*(n2+1) for i in range(n1+1)]
    for i in range(1,n1+1):
        for j in range(1,n2+1):
            if s1[i-1]==s2[j-1]:
                t[i][j]=1+t[i-1][j-1]
            else:
                t[i][j]=max(t[i][j-1],t[i-1][j])
    i,j=n1,n2
    sub=[]
    while i and j:
        if s1[i-1]==s2[j-1]:
            sub.append(i-1)
            i,j=i-1,j-1
        else:
            i,j=(i-1,j) if t[i-1][j]>t[i][j-1] else (i,j-1)
    sub.sort() # Now sub has indices of the string (s1,s2) which forms LCS
    return sub # length of LCS == len(sub)

def main():
    for _ in range_n():
        n,m=unpack()
        a=l_unpack()
        b=l_unpack()
        sub=lcs_bottom_up_subsequence(a,b,n,m)
        if sub:
            # ans=[a[i] for i in sub]
            print('YES')
            print(1,a[sub[0]])
        else:
            print('NO')


main()

