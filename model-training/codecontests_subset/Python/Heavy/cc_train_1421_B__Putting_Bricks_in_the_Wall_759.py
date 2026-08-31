from sys import stdin, stdout
import math
import heapq
import collections
input = stdin.readline
def inputnum():
    return(int(input()))
def inputnums():
    return(map(int,input().split()))
def inputlist():
    return(list(map(int,input().split())))
def inputstring():
    return([x for x in input()])
def inputstrings():
    return([x for x in input().split()])
def inputstringnum():
    return([ord(x)-ord('a') for x in input()])
def inputmatrixchar(rows):
    arr2d = [[j for j in input().strip()] for i in range(rows)] 
    return arr2d
def inputmatrixint(rows):
    arr2d = []
    for _ in range(rows):
        arr2d.append([int(i) for i in input().split()])
    return arr2d
    
t = int(input())
for q in range(t):
    n = inputnum()
    m = inputmatrixchar(n)
    ans1 = []
    ans2 = []
    a = m[0][1]
    b = m[1][0]
    c = m[n-1][n-2]
    d = m[n-2][n-1]
    if a == '0' and b == '0': 
        if c == '0': 
            ans1.append(n)
            ans1.append(n-1)
        if d == '0':
            ans2.append(n-1)
            ans2.append(n)
    elif a == '1' and b == '0':
        if c == '0' and d == '0':
            ans1.append(2)
            ans1.append(1)
        if c == '1' and d == '0':
            ans1.append(1)
            ans1.append(2)
            ans2.append(n-1)
            ans2.append(n)
        if c == '0' and d == '1':
            ans1.append(1)
            ans1.append(2)
            ans2.append(n)
            ans2.append(n-1)
        if c == '1' and d == '1':
            ans1.append(1)
            ans1.append(2)
    elif a == '0' and b =='1':
        if c == '0' and d == '0':
            ans1.append(1)
            ans1.append(2)
        if c == '1' and d == '0':
            ans1.append(1)
            ans1.append(2)
            ans2.append(n)
            ans2.append(n-1)
        if c == '0' and d == '1':
            ans1.append(1)
            ans1.append(2)
            ans2.append(n-1)
            ans2.append(n)
        if c == '1' and d == '1':
            ans1.append(2)
            ans1.append(1)
    else:
        if c == '1':
            ans1.append(n)
            ans1.append(n-1)
        if d == '1':
            ans2.append(n-1)
            ans2.append(n)
    cnt = (len(ans1) != 0) + (len(ans2) != 0);
    print(cnt)
    if len(ans1) != 0:
        print(*ans1)
    if len(ans2) != 0:
        print(*ans2)