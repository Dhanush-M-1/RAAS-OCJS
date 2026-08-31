# cook your dish here
from sys import stdin, stdout
import math
from itertools import permutations, combinations
from collections import defaultdict
 
def L():
    return list(map(int, stdin.readline().split()))
 
def In():
    return map(int, stdin.readline().split())
 
def I():
    return int(stdin.readline())
 
P = 1000000007
for t in range(I()):
    arr = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    n, m = In()
    s = input()
    lis = L()
    lis.append(n)
    lis.sort()
    arr1 = [0 for i in range(n)]
    lis = [0] + lis
    m += 2
    for i in range(1, m):
        for j in range(lis[i-1], lis[i]):
            arr1[j] += m-i 
    for i in range(n):
        arr[ord(s[i])-97] += arr1[i]
    print(*arr)